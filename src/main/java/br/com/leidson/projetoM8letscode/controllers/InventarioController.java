package br.com.leidson.projetoM8letscode.controllers;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import br.com.leidson.projetoM8letscode.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inventario>> detalhesCliente(@PathVariable String id) throws Exception {
        Integer idd = Integer.parseInt(id);
        Optional<Inventario> obj = service.find(idd);
        return ResponseEntity.ok().body(obj);
    }
}
