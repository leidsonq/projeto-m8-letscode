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

    public Inventario inserir(Inventario obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Inventario> buscar(Integer id) {
        Optional<Inventario> obj = repo.findById(id);
        return obj;
    }
}
