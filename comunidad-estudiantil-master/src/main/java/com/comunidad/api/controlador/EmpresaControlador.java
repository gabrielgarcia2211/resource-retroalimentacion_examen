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

import com.comunidad.api.modelo.entidad.Empresa;
import com.comunidad.api.modelo.servicio.implementacion.EmpresaServicioImpl;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaControlador {

	@Autowired
	private EmpresaServicioImpl empresaServicio;

	@RequestMapping
	public List<Empresa> listar() {
		return this.empresaServicio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Empresa empresa) {
		this.empresaServicio.save(empresa);
	}

	@RequestMapping("/{id}")
	public Empresa buscar(@PathVariable Integer id) {
		return this.empresaServicio.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Integer id, @RequestBody Empresa empresa) {
		empresa.setId(id);
		this.empresaServicio.save(empresa);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		this.empresaServicio.deleteById(id);
	}
}
