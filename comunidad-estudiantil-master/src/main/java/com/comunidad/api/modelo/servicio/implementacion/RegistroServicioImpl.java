package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IRegistroDao;
import com.comunidad.api.modelo.entidad.Registro;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("RegistroServicioImpl")
public class RegistroServicioImpl implements IServicio<Registro, Integer> {

	@Autowired
	private IRegistroDao registroDao;

	@Override
	@Transactional(readOnly = true)
	public List<Registro> findAll() {
		return (List<Registro>) this.registroDao.findAll();
	}

	@Override
	@Transactional
	public void save(Registro t) {
		this.registroDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Registro findById(Integer id) {
		return this.registroDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.registroDao.deleteById(id);
	}

}
