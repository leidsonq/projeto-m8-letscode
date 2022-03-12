package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository repo;

    public Rebelde inserir(Rebelde obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Rebelde> buscar(Integer id) {
        Optional<Rebelde> obj = repo.findById(id);
        return obj;
    }

    public Rebelde atualizar(Rebelde obj) {
        Optional<Rebelde> newObj = buscar(obj.getId());
        Rebelde rebelde = new Rebelde();
        if (newObj.isPresent()) {
           rebelde = newObj.get();
        }
        atualizarDados(rebelde, obj);
        return repo.save(rebelde);
    }

    private void atualizarDados(Rebelde newObj, Rebelde obj) {
        newObj.setGenero (obj.getGenero());
        newObj.setIdade(obj.getIdade());
        newObj.setInventario(obj.getInventario());
        newObj.setLocalizacao(obj.getLocalizacao());
        newObj.setNome(obj.getNome());
    }
    public boolean checarTraidor(Integer id) {
        Optional<Rebelde> rbd = buscar(id);
        Rebelde rebelde = new Rebelde();
        if(rbd.isPresent()) {
            rebelde = rbd.get();
        }

        if (rebelde.isTraidor()) {
            return true;
        } else {
            return false;
        }
    }

}
