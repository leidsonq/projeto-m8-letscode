package br.com.leidson.projetoM8letscode.controllers;

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
@RequestMapping("/rebelde")
public class RebeldeController {

    @Autowired
    RebeldeService service;

    @Autowired
    LocalizacaoService localizacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rebelde>> detalhesRebelde(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Rebelde> obj = service.find(idd);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Rebelde> cadastrarRebelde(
            @RequestBody Rebelde rebelde,
            UriComponentsBuilder uriComponentsBuilder
    ){
        rebelde = service.insert(rebelde);
        URI uri = uriComponentsBuilder.path("/rebelde/{id}").buildAndExpand(rebelde.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
