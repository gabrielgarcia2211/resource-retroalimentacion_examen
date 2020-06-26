package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cormobilidad")
public class Cormobilidad implements Serializable {

	@Id
	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties(value = { "cormobilidad" }, allowSetters = true)
	private Basico id;
	private Boolean diabetes;
	private Boolean cardio;
	private Boolean cerebro;
	private Boolean vih;
	private Boolean cancer;
	private Boolean corticoides;
	private Boolean epoc;
	private Boolean nutricion;
	private Boolean fumador;
	@Column(name = "fechareg")
	private Date fechaReg;
	private static final long serialVersionUID = 1L;

	public Cormobilidad() {
		super();
	}

	public Cormobilidad(Basico id, Boolean diabetes, Boolean cardio, Boolean cerebro, Boolean vih, Boolean cancer,
			Boolean corticoides, Boolean epoc, Boolean nutricion, Boolean fumador, Date fechaReg) {
		super();
		this.id = id;
		this.diabetes = diabetes;
		this.cardio = cardio;
		this.cerebro = cerebro;
		this.vih = vih;
		this.cancer = cancer;
		this.corticoides = corticoides;
		this.epoc = epoc;
		this.nutricion = nutricion;
		this.fumador = fumador;
		this.fechaReg = fechaReg;
	}

	@Override
	public String toString() {
		return "Cormobilidad [id=" + id + ", diabetes=" + diabetes + ", cardio=" + cardio + ", cerebro=" + cerebro
				+ ", vih=" + vih + ", cancer=" + cancer + ", corticoides=" + corticoides + ", epoc=" + epoc
				+ ", nutricion=" + nutricion + ", fumador=" + fumador + ", fechaReg=" + fechaReg + "]";
	}

	public Basico getId() {
		return id;
	}

	public void setId(Basico id) {
		this.id = id;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getCardio() {
		return cardio;
	}

	public void setCardio(Boolean cardio) {
		this.cardio = cardio;
	}

	public Boolean getCerebro() {
		return cerebro;
	}

	public void setCerebro(Boolean cerebro) {
		this.cerebro = cerebro;
	}

	public Boolean getVih() {
		return vih;
	}

	public void setVih(Boolean vih) {
		this.vih = vih;
	}

	public Boolean getCancer() {
		return cancer;
	}

	public void setCancer(Boolean cancer) {
		this.cancer = cancer;
	}

	public Boolean getCorticoides() {
		return corticoides;
	}

	public void setCorticoides(Boolean corticoides) {
		this.corticoides = corticoides;
	}

	public Boolean getEpoc() {
		return epoc;
	}

	public void setEpoc(Boolean epoc) {
		this.epoc = epoc;
	}

	public Boolean getNutricion() {
		return nutricion;
	}

	public void setNutricion(Boolean nutricion) {
		this.nutricion = nutricion;
	}

	public Boolean getFumador() {
		return fumador;
	}

	public void setFumador(Boolean fumador) {
		this.fumador = fumador;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
