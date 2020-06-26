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

import com.comunidad.api.modelo.entidad.Modalidad;
import com.comunidad.api.modelo.servicio.implementacion.ModalidadServicioImpl;

@RestController
@RequestMapping("/api/modalidad")
public class ModalidadControlador {

	@Autowired
	private ModalidadServicioImpl modalidadServicio;

	@RequestMapping
	public List<Modalidad> listar() {
		return this.modalidadServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Modalidad modalidad) {
		this.modalidadServicio.save(modalidad);
	}

	@RequestMapping("/{id}")
	public Modalidad buscar(@PathVariable Integer id) {
		return this.modalidadServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Modalidad modalidad) {
		modalidad.setId(id);
		this.modalidadServicio.save(modalidad);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.modalidadServicio.deleteById(id);
	}
}
