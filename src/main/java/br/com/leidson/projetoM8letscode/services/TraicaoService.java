package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.domain.Traicao;
import br.com.leidson.projetoM8letscode.repositories.TraicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TraicaoService {

    @Autowired
    TraicaoRepository repo;

    @Autowired
    RebeldeService rebeldeService;

    public Traicao inserir(Integer idDenunciante, Integer idDenunciado) {
        checarTraidor(idDenunciante, idDenunciado);
        Traicao obj = new Traicao(null, idDenunciante, idDenunciado);
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<Traicao> buscar(Integer id) {
        Optional<Traicao> obj = repo.findById(id);
        return obj;
    }
    public Optional<List<Traicao>> buscarTodos() {
        return Optional.of(repo.findAll());
    }

    public void checarTraidor(Integer idDenunciante, Integer idDenunciado) {
        if (!rebeldeService.checarTraidor(idDenunciado)) {
            int denuncia = 1;
            Optional<List<Traicao>> denunciasReportadas = buscarTodos();
            List<Traicao> denuncias = new ArrayList<>();
            if(denunciasReportadas.isPresent()) {
                denuncias = denunciasReportadas.get();
            }

            Set<Traicao> deunciasUnicas = obterDeunciasUnicas(denuncias);

            for (Traicao t: deunciasUnicas) {
                if(t.getIdDenunciado() == idDenunciado) {
                    denuncia++;
                }
            }

            if (denuncia >=3) {
                reportarTraidor(idDenunciado);
            }
        }
    }

    private void reportarTraidor(Integer id) {
        Optional<Rebelde> newObj = rebeldeService.buscar(id);
        Rebelde rebelde = new Rebelde();
        if (newObj.isPresent()) {
            rebelde = newObj.get();
        }
        rebelde.setTraidor(true);
        rebeldeService.atualizar(rebelde);
    }

    private Set<Traicao> obterDeunciasUnicas(List<Traicao> denuncias) {
        Set<Traicao> denunciasUnicas = new HashSet<Traicao>();
        for (Traicao t: denuncias) {
            denunciasUnicas.add(t);
        }
        return denunciasUnicas;
    }

}
