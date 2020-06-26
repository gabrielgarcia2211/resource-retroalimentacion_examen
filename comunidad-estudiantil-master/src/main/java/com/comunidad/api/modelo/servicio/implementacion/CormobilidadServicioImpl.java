package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.ICormobilidadDao;
import com.comunidad.api.modelo.entidad.Basico;
import com.comunidad.api.modelo.entidad.Cormobilidad;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("CormobilidadServicioImpl")
public class CormobilidadServicioImpl implements IServicio<Cormobilidad, Basico> {

	@Autowired
	private ICormobilidadDao cormobilidadDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cormobilidad> findAll() {
		return (List<Cormobilidad>) this.cormobilidadDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cormobilidad t) {
		this.cormobilidadDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Cormobilidad findById(Basico id) {
		return this.cormobilidadDao.findById(id);
	}

	@Override
	public void deleteById(Basico id) {
		this.cormobilidadDao.deleteById(id);
	}

}
