package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository repo;

    public Rebelde insert(Rebelde obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}