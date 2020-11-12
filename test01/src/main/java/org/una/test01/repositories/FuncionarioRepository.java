package org.una.test01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.test01.domain.Empresa;
import org.una.test01.domain.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("select funcionario from Funcionario funcionario where funcionario.empresa.id = ?1")
    public List<Funcionario> getFuncionarios(Long empresaId);
}
