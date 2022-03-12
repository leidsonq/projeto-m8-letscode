package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository repo;

    @Autowired
    RebeldeService rebeldeService;

    public Inventario inserir(Inventario obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Inventario> buscar(Integer id) {
        Optional<Inventario> obj = repo.findById(id);
        return obj;
    }

    public void atualizarInventarioRebelde (Integer idRebelde, Integer idInventario) {
        Optional<Rebelde> rebelde = rebeldeService.buscar(idRebelde);
        Rebelde novoRebelde = new Rebelde();
        if(rebelde.isPresent()){
            novoRebelde = rebelde.get();
        }
        Optional<Inventario> inventario = buscar(idInventario);
        Inventario novoInventario = new Inventario();
        if (inventario.isPresent()) {
            novoInventario = inventario.get();
        }
        novoRebelde.setInventario(novoInventario);
        rebeldeService.atualizar(novoRebelde);
    }

    public Inventario atualizar(Inventario obj) {
        Optional<Inventario> newObj = buscar(obj.getId());
        Inventario inventario = new Inventario();
        if (newObj.isPresent()) {
            inventario = newObj.get();
        }
        atualizarDados(inventario, obj);
        return repo.save(inventario);
    }

    private void atualizarDados(Inventario newObj, Inventario obj) {
        newObj.setItensInventario(obj.getItensInventario());
        newObj.setRebelde(obj.getRebelde());
    }
}
