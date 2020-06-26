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

import com.comunidad.api.modelo.entidad.Tipo;
import com.comunidad.api.modelo.servicio.implementacion.TipoServicioImpl;

@RestController
@RequestMapping("/api/tipo")
public class TipoControlador {

	@Autowired
	private TipoServicioImpl tipoServicio;

	@RequestMapping
	public List<Tipo> listar() {
		return this.tipoServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Tipo tipo) {
		this.tipoServicio.save(tipo);
	}

	@RequestMapping("/{id}")
	public Tipo buscar(@PathVariable Integer id) {
		return this.tipoServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Tipo tipo) {
		tipo.setId(id);
		this.tipoServicio.save(tipo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.tipoServicio.deleteById(id);
	}
}
