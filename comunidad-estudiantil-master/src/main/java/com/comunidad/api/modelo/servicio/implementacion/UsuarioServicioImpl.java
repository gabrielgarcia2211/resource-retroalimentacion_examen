package com.comunidad.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comunidad.api.modelo.dao.interfaz.IUsuarioDao;
import com.comunidad.api.modelo.entidad.Usuario;
import com.comunidad.api.modelo.servicio.interfaz.IServicio;

@Service("UsuarioServicioImpl")
public class UsuarioServicioImpl implements IServicio<Usuario, Integer> {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) this.usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario t) {
		this.usuarioDao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		return this.usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Integer id) {
		this.usuarioDao.deleteById(id);
	}

}
