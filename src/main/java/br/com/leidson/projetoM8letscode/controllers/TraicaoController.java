package br.com.leidson.projetoM8letscode.controllers;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.domain.Traicao;
import br.com.leidson.projetoM8letscode.services.TraicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/traicao")
public class TraicaoController {

    @Autowired
    TraicaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Traicao>> detalhesTraicao(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Traicao> obj = service.buscar(idd);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Rebelde> cadastrarTraicao(
            @RequestBody Traicao traicao,
            UriComponentsBuilder uriComponentsBuilder,
            @RequestParam (value="denunciante") String idDenunciante, @RequestParam (value="denunciado") String idDenunciado
    ){
        Integer id1 = Integer.parseInt(idDenunciante);
        Integer id2 = Integer.parseInt(idDenunciado);
        traicao = service.inserir(id1, id2);
        URI uri = uriComponentsBuilder.path("/traicao/{id}").buildAndExpand(traicao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
