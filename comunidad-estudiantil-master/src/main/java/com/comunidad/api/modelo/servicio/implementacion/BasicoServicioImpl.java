package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IBasicoDao;
import com.comunidad.api.modelo.entidad.Basico;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("BasicoServicioImpl")
public class BasicoServicioImpl implements IServicio<Basico, Integer> {

	@Autowired
	private IBasicoDao basicoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Basico> findAll() {
		return (List<Basico>) this.basicoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Basico t) {
		this.basicoDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Basico findById(Integer id) {
		return this.basicoDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.basicoDao.deleteById(id);
	}

}
