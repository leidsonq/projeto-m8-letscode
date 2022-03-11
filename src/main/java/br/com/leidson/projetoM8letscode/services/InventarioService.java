package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import br.com.leidson.projetoM8letscode.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository repo;

    public Inventario insert(Inventario obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Inventario> find(Integer id) {
        Optional<Inventario> obj = repo.findById(id);
        return obj;
    }
}
