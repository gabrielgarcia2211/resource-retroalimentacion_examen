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

import com.comunidad.api.modelo.entidad.AccesoVisitante;
import com.comunidad.api.modelo.servicio.implementacion.AccesoVisitanteServicioImpl;

@RestController
@RequestMapping("/api/accesoVisitante")
public class AccesoVisitanteControlador {

	@Autowired
	private AccesoVisitanteServicioImpl accesoVisitanteServicio;

	@RequestMapping
	public List<AccesoVisitante> listar() {
		return this.accesoVisitanteServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody AccesoVisitante accesoVisitante) {
		this.accesoVisitanteServicio.save(accesoVisitante);
	}

	@RequestMapping("/{id}")
	public AccesoVisitante buscar(@PathVariable Integer id) {
		return this.accesoVisitanteServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody AccesoVisitante accesoVisitante) {
		accesoVisitante.setId(id);
		this.accesoVisitanteServicio.save(accesoVisitante);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.accesoVisitanteServicio.deleteById(id);
	}
}
