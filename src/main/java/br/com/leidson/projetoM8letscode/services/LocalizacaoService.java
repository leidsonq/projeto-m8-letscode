package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Localizacao;
import br.com.leidson.projetoM8letscode.repositories.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repo;

    public Localizacao insert(Localizacao obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
