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

import com.comunidad.api.modelo.entidad.Registro;
import com.comunidad.api.modelo.servicio.implementacion.RegistroServicioImpl;

@RestController
@RequestMapping("/api/registro")
public class RegistroControlador {

	@Autowired
	private RegistroServicioImpl registroServicio;

	@RequestMapping
	public List<Registro> listar() {
		return this.registroServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Registro registro) {
		this.registroServicio.save(registro);
	}

	@RequestMapping("/{id}")
	public Registro buscar(@PathVariable Integer id) {
		return this.registroServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Registro registro) {
		registro.setId(id);
		this.registroServicio.save(registro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.registroServicio.deleteById(id);
	}
}
