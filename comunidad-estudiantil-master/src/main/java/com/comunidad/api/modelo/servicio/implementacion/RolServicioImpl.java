package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IRolDao;
import com.comunidad.api.modelo.entidad.Rol;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("RolServicioImpl")
public class RolServicioImpl implements IServicio<Rol, Integer> {

	@Autowired
	private IRolDao rolDao;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return (List<Rol>) this.rolDao.findAll();
	}

	@Override
	@Transactional
	public void save(Rol t) {
		this.rolDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Rol findById(Integer id) {
		return this.rolDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.rolDao.deleteById(id);
	}

}
