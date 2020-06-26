package com.comunidad.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.comunidad.api.modelo.entidad.Empresa;

public interface IEmpresaDao extends CrudRepository<Empresa, Integer> {

}
