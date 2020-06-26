package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IEmpresaDao;
import com.comunidad.api.modelo.entidad.Empresa;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("EmpresaServicioImpl")
public class EmpresaServicioImpl implements IServicio<Empresa, Integer> {

	@Autowired
	private IEmpresaDao empresaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return (List<Empresa>) this.empresaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Empresa t) {
		this.empresaDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Integer id) {
		return this.empresaDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.empresaDao.deleteById(id);
	}

}
