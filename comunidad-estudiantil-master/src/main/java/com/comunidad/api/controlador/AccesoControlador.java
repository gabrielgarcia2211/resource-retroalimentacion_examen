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

import com.comunidad.api.modelo.entidad.Acceso;
import com.comunidad.api.modelo.servicio.implementacion.AccesoServicioImpl;

@RestController
@RequestMapping("/api/acceso")
public class AccesoControlador {

	@Autowired
	private AccesoServicioImpl accesoServicio;

	@RequestMapping
	public List<Acceso> listar() {
		return this.accesoServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Acceso acceso) {
		this.accesoServicio.save(acceso);
	}

	@RequestMapping("/{id}")
	public Acceso buscar(@PathVariable Integer id) {
		return this.accesoServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Acceso acceso) {
		acceso.setId(id);
		this.accesoServicio.save(acceso);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.accesoServicio.deleteById(id);
	}
}
