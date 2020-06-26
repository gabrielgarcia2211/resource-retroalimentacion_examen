package com.comunidad.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.comunidad.api.modelo.entidad.Registro;

public interface IRegistroDao extends CrudRepository<Registro, Integer> {

}
