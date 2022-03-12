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

    @Autowired
    RebeldeService rebeldeService;

    public Localizacao inserir(Localizacao obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Localizacao> buscar(Integer id) {
        Optional<Localizacao> obj = repo.findById(id);
        return obj;
    }

    public void atualizarLocalizacaoRebelde (Integer idRebelde, Integer idLocalizacao) {
        Optional<Rebelde> rebelde = rebeldeService.buscar(idRebelde);
        Rebelde novoRebelde = new Rebelde();
        if(rebelde.isPresent()){
            novoRebelde = rebelde.get();
        }
        Optional<Localizacao> localizacao = buscar(idLocalizacao);
        Localizacao novaLocalizacao = new Localizacao();
        if (localizacao.isPresent()) {
            novaLocalizacao = localizacao.get();
        }
        novoRebelde.setLocalizacao(novaLocalizacao);
        rebeldeService.atualizar(novoRebelde);
    }

    public Localizacao atualizar(Localizacao obj) {
        Optional<Localizacao> newObj = buscar(obj.getId());
        Localizacao localizacao = new Localizacao();
        if (newObj.isPresent()) {
            localizacao = newObj.get();
        }
        atualizarDados(localizacao, obj);
        return repo.save(localizacao);
    }

    private void atualizarDados(Localizacao newObj, Localizacao obj) {
        newObj.setLatitude(obj.getLatitude());
        newObj.setLongitude(obj.getLongitude());
        newObj.setNome(obj.getNome());
    }
}
