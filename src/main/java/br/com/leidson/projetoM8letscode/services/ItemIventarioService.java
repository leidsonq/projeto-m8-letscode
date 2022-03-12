package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.ItemIventario;
import br.com.leidson.projetoM8letscode.repositories.ItemInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemIventarioService {
    @Autowired
    private ItemInventarioRepository repo;

    public ItemIventario inserir(ItemIventario obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
