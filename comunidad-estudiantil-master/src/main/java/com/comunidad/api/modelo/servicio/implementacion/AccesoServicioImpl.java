package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IAccesoDao;
import com.comunidad.api.modelo.entidad.Acceso;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("AccesoServicioImpl")
public class AccesoServicioImpl implements IServicio<Acceso, Integer> {

	@Autowired
	private IAccesoDao accesoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Acceso> findAll() {
		return (List<Acceso>) this.accesoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Acceso t) {
		this.accesoDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Acceso findById(Integer id) {
		return this.accesoDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.accesoDao.deleteById(id);
	}

}
