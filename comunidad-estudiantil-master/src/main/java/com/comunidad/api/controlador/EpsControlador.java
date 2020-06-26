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

import com.comunidad.api.modelo.entidad.Eps;
import com.comunidad.api.modelo.servicio.implementacion.EpsServicioImpl;

@RestController
@RequestMapping("/api/eps")
public class EpsControlador {

	@Autowired
	private EpsServicioImpl epsServicio;

	@RequestMapping
	public List<Eps> listar() {
		return this.epsServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Eps eps) {
		this.epsServicio.save(eps);
	}

	@RequestMapping("/{id}")
	public Eps buscar(@PathVariable Integer id) {
		return this.epsServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Eps eps) {
		eps.setId(id);
		this.epsServicio.save(eps);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.epsServicio.deleteById(id);
	}
}
