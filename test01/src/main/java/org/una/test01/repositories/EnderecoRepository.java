package org.una.test01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.una.test01.domain.Endereco;
import org.una.test01.domain.Funcionario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
