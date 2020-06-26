package com.comunidad.api.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comunidad.api.modelo.entidad.Usuario;
import com.comunidad.api.modelo.servicio.implementacion.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	@RequestMapping
	public List<Usuario> listar() {
		return this.usuarioServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Usuario usuario) {
		this.usuarioServicio.save(usuario);
	}

	@RequestMapping("/{id}")
	public Usuario buscar(@PathVariable Integer id) {
		return this.usuarioServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		this.usuarioServicio.save(usuario);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.usuarioServicio.deleteById(id);
	}
}
