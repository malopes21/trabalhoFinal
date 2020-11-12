package org.una.test01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.test01.domain.Funcionario;
import org.una.test01.services.interfaces.FuncionarioServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioServiceAPI service;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<Funcionario>> findAll() {

        List<Funcionario> funcionarios = service.findAll();

        if(funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Funcionario> get(@PathVariable(name = "id") Long id) {

        Funcionario funcionario = service.get(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Funcionario> create(@RequestBody Funcionario funcionario) {

        funcionario = service.create(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Funcionario> update(@PathVariable(name = "id") Long id,
                             @RequestBody Funcionario funcionario) {

        funcionario.setId(id);
        service.update(funcionario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Funcionario> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.ok().build();
    }
}
