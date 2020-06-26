package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IAccesoVisitanteDao;
import com.comunidad.api.modelo.entidad.AccesoVisitante;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("AccesoVisitanteServicioImpl")
public class AccesoVisitanteServicioImpl implements IServicio<AccesoVisitante, Integer> {

	@Autowired
	private IAccesoVisitanteDao accesoVisitanteDao;

	@Override
	@Transactional(readOnly = true)
	public List<AccesoVisitante> findAll() {
		return (List<AccesoVisitante>) this.accesoVisitanteDao.findAll();
	}

	@Override
	@Transactional
	public void save(AccesoVisitante t) {
		this.accesoVisitanteDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public AccesoVisitante findById(Integer id) {
		return this.accesoVisitanteDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.accesoVisitanteDao.deleteById(id);
	}

}
