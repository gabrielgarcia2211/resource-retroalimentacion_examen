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

import com.comunidad.api.modelo.entidad.Cormobilidad;
import com.comunidad.api.modelo.servicio.implementacion.BasicoServicioImpl;
import com.comunidad.api.modelo.servicio.implementacion.CormobilidadServicioImpl;

@RestController
@RequestMapping("/api/cormobilidad")
public class CormobilidadControlador {

	@Autowired
	private CormobilidadServicioImpl cormobilidadServicio;
	@Autowired
	private BasicoServicioImpl basicoServicio;

	@RequestMapping
	public List<Cormobilidad> listar() {
		return this.cormobilidadServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Cormobilidad cormobilidad) {
		this.cormobilidadServicio.save(cormobilidad);
	}

	@RequestMapping("/{id}")
	public Cormobilidad buscar(@PathVariable Integer id) {
		return this.cormobilidadServicio.findById(basicoServicio.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Cormobilidad cormobilidad) {
		cormobilidad.setId(basicoServicio.findById(id));
		this.cormobilidadServicio.save(cormobilidad);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.cormobilidadServicio.deleteById(basicoServicio.findById(id));
	}
}
