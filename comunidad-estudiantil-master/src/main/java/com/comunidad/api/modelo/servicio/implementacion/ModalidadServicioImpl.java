package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IModalidadDao;
import com.comunidad.api.modelo.entidad.Modalidad;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("ModalidadServicioImpl")
public class ModalidadServicioImpl implements IServicio<Modalidad, Integer> {

	@Autowired
	private IModalidadDao modalidadDao;

	@Override
	@Transactional(readOnly = true)
	public List<Modalidad> findAll() {
		return (List<Modalidad>) this.modalidadDao.findAll();
	}

	@Override
	@Transactional
	public void save(Modalidad t) {
		this.modalidadDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Modalidad findById(Integer id) {
		return this.modalidadDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.modalidadDao.deleteById(id);
	}

}
