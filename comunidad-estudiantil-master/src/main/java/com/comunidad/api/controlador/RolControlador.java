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

import com.comunidad.api.modelo.entidad.Rol;
import com.comunidad.api.modelo.servicio.implementacion.RolServicioImpl;

@RestController
@RequestMapping("/api/rol")
public class RolControlador {

	@Autowired
	private RolServicioImpl rolServicio;

	@RequestMapping
	public List<Rol> listar() {
		return this.rolServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Rol rol) {
		this.rolServicio.save(rol);
	}

	@RequestMapping("/{id}")
	public Rol buscar(@PathVariable Integer id) {
		return this.rolServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
		rol.setId(id);
		this.rolServicio.save(rol);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.rolServicio.deleteById(id);
	}
}
