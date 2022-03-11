package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Localizacao;
import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repo;

    public Localizacao insert(Localizacao obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Localizacao> find(Integer id) {
        Optional<Localizacao> obj = repo.findById(id);
        return obj;
    }
}
