package com.comunidad.api.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "empresa")
	@JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
	private Empresa empresa;
	private String usuario;
	private String email;
	private String clave;
	@ManyToOne
	@JoinColumn(name = "rol")
	@JsonIgnoreProperties(value = { "usuario" }, allowSetters = true)
	private Rol rol;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, Empresa empresa, String usuario, String email, String clave, Rol rol) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.usuario = usuario;
		this.email = email;
		this.clave = clave;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", empresa=" + empresa + ", usuario=" + usuario + ", email=" + email + ", clave="
				+ clave + ", rol=" + rol + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
