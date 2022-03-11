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

    public Rebelde insert(Rebelde obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Rebelde> find(Integer id) {
        Optional<Rebelde> obj = repo.findById(id);
        return obj;
    }

    public Rebelde update(Rebelde obj) {
        Optional<Rebelde> newObj = find(obj.getId());
        Rebelde rebelde = new Rebelde();
        if (newObj.isPresent()) {
           rebelde = newObj.get();
        }
        updateData (rebelde, obj);
        return repo.save(rebelde);
    }

    private void updateData (Rebelde newObj, Rebelde obj) {
        newObj.setGenero (obj.getGenero());
        newObj.setIdade(obj.getIdade());
        newObj.setInventario(obj.getInventario());
        newObj.setLocalizacao(obj.getLocalizacao());
        newObj.setNome(obj.getNome());
    }


}
