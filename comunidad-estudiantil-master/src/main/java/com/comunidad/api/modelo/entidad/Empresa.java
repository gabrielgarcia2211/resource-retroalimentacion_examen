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
@Table(name = "empresa")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String endpoint;
	private Boolean estado;
	private String code;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "empresa" }, allowSetters = true)
	private Set<Usuario> usuario;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "empresa" }, allowSetters = true)
	private Set<Tipo> tipo;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "empresa" }, allowSetters = true)
	private Set<Visitante> visitante;
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();
	}

	public Empresa(Integer id, String nombre, String endpoint, Boolean estado, String code, Set<Usuario> usuario,
			Set<Tipo> tipo, Set<Visitante> visitante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.endpoint = endpoint;
		this.estado = estado;
		this.code = code;
		this.usuario = usuario;
		this.tipo = tipo;
		this.visitante = visitante;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", endpoint=" + endpoint + ", estado=" + estado + ", code="
				+ code + ", usuario=" + usuario + ", tipo=" + tipo + ", visitante=" + visitante + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Set<Tipo> getTipo() {
		return tipo;
	}

	public void setTipo(Set<Tipo> tipo) {
		this.tipo = tipo;
	}

	public Set<Visitante> getVisitante() {
		return visitante;
	}

	public void setVisitante(Set<Visitante> visitante) {
		this.visitante = visitante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
