package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipo")
public class Tipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "empresa")
	@JsonIgnoreProperties(value = { "tipo" }, allowSetters = true)
	private Empresa empresa;
	@OneToMany(mappedBy = "tipo")
	@JsonIgnoreProperties(value = { "tipo" }, allowSetters = true)
	private Set<Basico> basico;
	private static final long serialVersionUID = 1L;

	public Tipo() {
		super();
	}

	public Tipo(Integer id, String descripcion, Empresa empresa, Set<Basico> basico) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.empresa = empresa;
		this.basico = basico;
	}

	@Override
	public String toString() {
		return "Tipo [id=" + id + ", descripcion=" + descripcion + ", empresa=" + empresa + ", basico=" + basico + "]";
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
