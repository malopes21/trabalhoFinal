package org.una.test01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.test01.domain.Empresa;
import org.una.test01.domain.Funcionario;
import org.una.test01.services.interfaces.EmpresaServiceAPI;
import org.una.test01.services.interfaces.FuncionarioServiceAPI;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

    @Autowired
    private EmpresaServiceAPI service;

    @Autowired
    private FuncionarioServiceAPI funcionarioService;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<Empresa>> findAll() {

        List<Empresa> empresas = service.findAll();

        if(empresas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(empresas);
    }

    @GetMapping(value = "/{id}/funcionarios")
    public @ResponseBody
    HttpEntity<List<Funcionario>> getFuncionarios(@PathVariable(name = "id") Long empresaId) {

        Empresa empresa = service.get(empresaId);

        List<Funcionario> funcionarios = funcionarioService.getFuncionarios(empresaId);

        if(funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Empresa> get(@PathVariable(name = "id") Long id) {

        Empresa empresa = service.get(id);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<Empresa> create(@RequestBody Empresa empresa) {

        empresa = service.create(empresa);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Empresa> update(@PathVariable(name = "id") Long id,
                             @RequestBody Empresa empresa) {

        empresa.setId(id);
        service.update(empresa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Empresa> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);
        return ResponseEntity.ok().build();
    }
}
