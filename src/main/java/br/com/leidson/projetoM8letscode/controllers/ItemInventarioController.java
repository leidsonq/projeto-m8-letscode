package br.com.leidson.projetoM8letscode.controllers;


import br.com.leidson.projetoM8letscode.domain.ItemIventario;
import br.com.leidson.projetoM8letscode.services.ItemIventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/iteminventario")
public class ItemInventarioController {

    @Autowired
    ItemIventarioService service;

    @PostMapping
    public ResponseEntity<ItemIventario> cadastraItemInventario(
            @Valid @RequestBody ItemIventario itemIventario,
            UriComponentsBuilder uriComponentsBuilder
    ){
        itemIventario = service.inserir(itemIventario);
        URI uri = uriComponentsBuilder.path("/iteminventario/{id}").buildAndExpand(itemIventario.getId()).toUri();
        service.atualizarInventario (itemIventario.getInventario().getId(), itemIventario.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemIventario>> detalhesItemInventario(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<ItemIventario> obj = service.buscar(idd);
        return ResponseEntity.ok().body(obj);
    }
}
