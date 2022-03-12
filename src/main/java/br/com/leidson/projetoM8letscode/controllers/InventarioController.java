package br.com.leidson.projetoM8letscode.controllers;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import br.com.leidson.projetoM8letscode.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inventario>> detalhesInventario(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Inventario> obj = service.buscar(idd);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Inventario> cadastrarInventario(
            @Valid @RequestBody Inventario inventario,
            UriComponentsBuilder uriComponentsBuilder
    ){
        inventario = service.inserir(inventario);
        URI uri = uriComponentsBuilder.path("/inventario/{id}").buildAndExpand(inventario.getId()).toUri();
        service.atualizarInventarioRebelde(inventario.getRebelde().getId(),inventario.getId());
        return ResponseEntity.created(uri).build();
    }
}
