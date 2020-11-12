package org.una.test01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.test01.domain.Endereco;
import org.una.test01.exceptions.EnderecoNotFoundException;
import org.una.test01.repositories.EnderecoRepository;
import org.una.test01.services.interfaces.EnderecoServiceAPI;

import java.util.List;

@Service
public class EnderecoService implements EnderecoServiceAPI {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public Endereco get(Long id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex){
            throw new EnderecoNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @Override
    public Endereco create(Endereco endereco) {
        return repository.save(endereco);
    }

    @Override
    public void update(Endereco endereco) {
        repository.save(endereco);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
