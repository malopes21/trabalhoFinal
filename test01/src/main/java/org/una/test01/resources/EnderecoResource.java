package org.una.test01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.test01.domain.Endereco;
import org.una.test01.services.interfaces.EnderecoServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoServiceAPI service;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<Endereco>> findAll() {

        List<Endereco> enderecos = service.findAll();

        if(enderecos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(enderecos);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Endereco> get(@PathVariable(name = "id") Long id) {

        Endereco endereco = service.get(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Endereco> create(@RequestBody Endereco endereco) {

        endereco = service.create(endereco);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Endereco> update(@PathVariable(name = "id") Long id,
                             @RequestBody Endereco endereco) {

        endereco.setId(id);
        service.update(endereco);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Endereco> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.ok().build();
    }
}
