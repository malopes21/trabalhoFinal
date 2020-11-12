package org.una.test01.services.interfaces;


import org.una.test01.domain.Empresa;

import java.util.List;

public interface EmpresaServiceAPI {

    public Empresa get(Long id);

    public List<Empresa> findAll();

    public Empresa create(Empresa empresa);

    public void update(Empresa empresa);

    public void remove(Long id);
}
