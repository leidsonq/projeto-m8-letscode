package br.com.leidson.projetoM8letscode.controllers;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.services.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/rebelde")
public class RebeldeController {

    @Autowired
    RebeldeService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rebelde>> detalhesRebelde(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Rebelde> obj = service.buscar(idd);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Rebelde> cadastrarRebelde(
            @Valid @RequestBody Rebelde rebelde,
            UriComponentsBuilder uriComponentsBuilder
    ){
        rebelde = service.inserir(rebelde);
        URI uri = uriComponentsBuilder.path("/rebelde/{id}").buildAndExpand(rebelde.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rebelde> atualizaRebelde(
            @PathVariable String id,
            @RequestBody Rebelde rebelde
    ) throws Exception {
        Integer idd = Integer.parseInt(id);
        rebelde.setId(idd);
        rebelde = service.atualizar(rebelde);
        return ResponseEntity.ok().build();
    }
}
