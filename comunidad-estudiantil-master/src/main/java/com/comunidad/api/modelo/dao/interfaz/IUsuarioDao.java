package com.comunidad.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.comunidad.api.modelo.entidad.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

}
