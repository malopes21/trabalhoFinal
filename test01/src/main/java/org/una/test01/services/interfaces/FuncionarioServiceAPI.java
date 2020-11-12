package org.una.test01.services.interfaces;


import org.una.test01.domain.Funcionario;

import java.util.List;

public interface FuncionarioServiceAPI {

    public Funcionario get(Long id);

    public List<Funcionario> findAll();

    public Funcionario create(Funcionario funcionario);

    public void update(Funcionario funcionario);

    public void remove(Long id);

    public List<Funcionario> getFuncionarios(Long empresaId);
}
