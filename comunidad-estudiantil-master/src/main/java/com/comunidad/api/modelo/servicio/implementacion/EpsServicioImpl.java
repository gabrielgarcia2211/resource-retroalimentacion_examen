package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IEpsDao;
import com.comunidad.api.modelo.entidad.Eps;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("EpsServicioImpl")
public class EpsServicioImpl implements IServicio<Eps, Integer> {

	@Autowired
	private IEpsDao epsDao;

	@Override
	@Transactional(readOnly = true)
	public List<Eps> findAll() {
		return (List<Eps>) this.epsDao.findAll();
	}

	@Override
	@Transactional
	public void save(Eps t) {
		this.epsDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Eps findById(Integer id) {
		return this.epsDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.epsDao.deleteById(id);
	}

}
