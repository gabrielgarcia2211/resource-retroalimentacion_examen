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

import com.comunidad.api.modelo.entidad.Visitante;
import com.comunidad.api.modelo.servicio.implementacion.VisitanteServicioImpl;

@RestController
@RequestMapping("/api/visitante")
public class VisitanteControlador {

	@Autowired
	private VisitanteServicioImpl visitanteServicio;

	@RequestMapping
	public List<Visitante> listar() {
		return this.visitanteServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Visitante visitante) {
		this.visitanteServicio.save(visitante);
	}

	@RequestMapping("/{id}")
	public Visitante buscar(@PathVariable Integer id) {
		return this.visitanteServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Visitante visitante) {
		visitante.setId(id);
		this.visitanteServicio.save(visitante);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.visitanteServicio.deleteById(id);
	}
}
