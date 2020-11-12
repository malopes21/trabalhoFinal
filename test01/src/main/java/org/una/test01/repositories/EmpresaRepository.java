package org.una.test01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.test01.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
