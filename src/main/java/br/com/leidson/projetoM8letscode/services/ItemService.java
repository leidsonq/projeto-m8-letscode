package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Item;
import br.com.leidson.projetoM8letscode.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public Item insert(Item obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
