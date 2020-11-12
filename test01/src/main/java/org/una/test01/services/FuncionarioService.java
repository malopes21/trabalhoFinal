package org.una.test01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.test01.domain.Empresa;
import org.una.test01.domain.Funcionario;
import org.una.test01.exceptions.FuncionarioNotFoundException;
import org.una.test01.repositories.FuncionarioRepository;
import org.una.test01.services.interfaces.EmpresaServiceAPI;
import org.una.test01.services.interfaces.FuncionarioServiceAPI;

import java.util.List;

@Service
public class FuncionarioService implements FuncionarioServiceAPI {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private EmpresaServiceAPI empresaService;

    @Override
    public Funcionario get(Long id) {
        try {
            return repository.findById(id).get();
        } catch (Exception ex){
            throw new FuncionarioNotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    @Override
    public Funcionario create(Funcionario funcionario) {

        if(funcionario.getEmpresa() == null || funcionario.getEmpresa().getId() == null) {
            throw new IllegalArgumentException("Empresa é obrigatório para o cadastro do funcionário");
        }

        Empresa empresa = empresaService.get(funcionario.getEmpresa().getId());

        funcionario.setEmpresa(empresa);

        return repository.save(funcionario);
    }

    @Override
    public void update(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Funcionario> getFuncionarios(Long empresaId) {
        return repository.getFuncionarios(empresaId);
    }
}
