package com.comunidad.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.comunidad.api.modelo.entidad.Visitante;

public interface IVisitanteDao extends CrudRepository<Visitante, Integer> {

}
