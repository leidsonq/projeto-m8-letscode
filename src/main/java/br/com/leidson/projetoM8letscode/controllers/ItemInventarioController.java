package br.com.leidson.projetoM8letscode.controllers;


import br.com.leidson.projetoM8letscode.domain.ItemIventario;
import br.com.leidson.projetoM8letscode.services.ItemIventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/iteminventario")
public class ItemInventarioController {

    @Autowired
    ItemIventarioService service;

    @PostMapping
    public ResponseEntity<ItemIventario> cadastraCliente(
            @RequestBody ItemIventario itemIventario,
            UriComponentsBuilder uriComponentsBuilder
    ){
        itemIventario = service.inserir(itemIventario);
        URI uri = uriComponentsBuilder.path("/iteminventario/{id}").buildAndExpand(itemIventario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
