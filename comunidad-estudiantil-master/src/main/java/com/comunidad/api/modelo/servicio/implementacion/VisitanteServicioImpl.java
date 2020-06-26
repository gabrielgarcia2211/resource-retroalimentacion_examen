package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IVisitanteDao;
import com.comunidad.api.modelo.entidad.Visitante;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("VisitanteServicioImpl")
public class VisitanteServicioImpl implements IServicio<Visitante, Integer> {

	@Autowired
	private IVisitanteDao visitanteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Visitante> findAll() {
		return (List<Visitante>) this.visitanteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Visitante t) {
		this.visitanteDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Visitante findById(Integer id) {
		return this.visitanteDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.visitanteDao.deleteById(id);
	}

}
