package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "accesovisitante")
public class AccesoVisitante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fecha;
	private Integer temperatura;
	@ManyToOne
	@JoinColumn(name = "visitante")
	@JsonIgnoreProperties(value = { "accesoVisitante" }, allowSetters = true)
	private Visitante visitante;
	private static final long serialVersionUID = 1L;

	public AccesoVisitante() {
		super();
	}

	public AccesoVisitante(Integer id, Date fecha, Integer temperatura, Visitante visitante) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.visitante = visitante;
	}

	@Override
	public String toString() {
		return "AccesoVisitante [id=" + id + ", fecha=" + fecha + ", temperatura=" + temperatura + ", visitante="
				+ visitante + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
