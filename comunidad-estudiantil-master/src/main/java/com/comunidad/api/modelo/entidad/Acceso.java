package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acceso")
public class Acceso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "registro")
	@JsonIgnoreProperties(value = { "acceso" }, allowSetters = true)
	private Registro registro;
	@Column(name = "fechareg")
	private Date fechaReg;
	private Integer estado;
	private static final long serialVersionUID = 1L;

	public Acceso() {
		super();
	}

	public Acceso(Integer id, Registro registro, Date fechaReg, Integer estado) {
		super();
		this.id = id;
		this.registro = registro;
		this.fechaReg = fechaReg;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Acceso [id=" + id + ", registro=" + registro + ", fechaReg=" + fechaReg + ", estado=" + estado + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
