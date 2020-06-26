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

import com.comunidad.api.modelo.entidad.Basico;
import com.comunidad.api.modelo.servicio.implementacion.BasicoServicioImpl;

@RestController
@RequestMapping("/api/basico")
public class BasicoControlador {

	@Autowired
	private BasicoServicioImpl basicoServicio;

	@RequestMapping
	public List<Basico> listar() {
		return this.basicoServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Basico basico) {
		this.basicoServicio.save(basico);
	}

	@RequestMapping("/{id}")
	public Basico buscar(@PathVariable Integer id) {
		return this.basicoServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Basico basico) {
		basico.setId(id);
		this.basicoServicio.save(basico);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.basicoServicio.deleteById(id);
	}
}
