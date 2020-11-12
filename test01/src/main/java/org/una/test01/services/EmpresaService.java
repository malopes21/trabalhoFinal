package org.una.test01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.test01.domain.Empresa;
import org.una.test01.exceptions.EmpresaNotFoundException;
import org.una.test01.repositories.EmpresaRepository;
import org.una.test01.services.interfaces.EmpresaServiceAPI;

import java.util.List;

@Service
public class EmpresaService implements EmpresaServiceAPI {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public Empresa get(Long id) {
        try {

            return repository.findById(id).get();
            
        } catch (Exception ex){
            throw new EmpresaNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Empresa> findAll() {
        return repository.findAll();
    }

    @Override
    public Empresa create(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        repository.save(empresa);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
