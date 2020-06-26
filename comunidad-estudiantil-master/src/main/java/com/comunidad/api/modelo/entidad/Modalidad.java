package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "modalidad")
public class Modalidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	@OneToMany(mappedBy = "modalidad", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "modalidad" }, allowSetters = true)
	private Set<Basico> basico;
	private static final long serialVersionUID = 1L;

	public Modalidad() {
		super();
	}

	public Modalidad(Integer id, String descripcion, Set<Basico> basico) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.basico = basico;
	}

	@Override
	public String toString() {
		return "Modalidad [id=" + id + ", descripcion=" + descripcion + ", basico=" + basico + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Basico> getBasico() {
		return basico;
	}

	public void setBasico(Set<Basico> basico) {
		this.basico = basico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
