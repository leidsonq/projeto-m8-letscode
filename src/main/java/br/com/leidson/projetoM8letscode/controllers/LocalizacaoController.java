package br.com.leidson.projetoM8letscode.controllers;

import br.com.leidson.projetoM8letscode.domain.Localizacao;
import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.services.LocalizacaoService;
import br.com.leidson.projetoM8letscode.services.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Localizacao>> detalhesLocalizacao(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Localizacao> obj = service.find(idd);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Rebelde> cadastrarLocalizacao(
            @RequestBody Localizacao localizacao,
            UriComponentsBuilder uriComponentsBuilder
    ){
        localizacao = service.insert(localizacao);
        URI uri = uriComponentsBuilder.path("/localizacao/{id}").buildAndExpand(localizacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
