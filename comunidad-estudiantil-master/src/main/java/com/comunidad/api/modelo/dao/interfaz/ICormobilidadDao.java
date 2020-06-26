package com.comunidad.api.modelo.dao.interfaz;

import java.util.List;

import com.comunidad.api.modelo.entidad.Basico;
import com.comunidad.api.modelo.entidad.Cormobilidad;

public interface ICormobilidadDao {
	public List<Cormobilidad> findAll();

	public void save(Cormobilidad cliente);

	public Cormobilidad findById(Basico id);

	public void deleteById(Basico id);
}
