package com.comunidad.api.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "registro")
public class Registro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "persona")
	@JsonIgnoreProperties(value = { "registro" }, allowSetters = true)
	private Basico persona;
	private Date fecha;
	private Boolean tos;
	private Boolean malestar;
	private Boolean fatiga;
	private Boolean nasal;
	private Boolean garganta;
	private Boolean dificultad;
	@Column(columnDefinition = "Decimal(3,1) default '0.00'")
	private Double temperatura;
	@Column(name = "fechareg")
	private Date fechaReg;
	private Boolean covid;
	@OneToMany(mappedBy = "registro", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "registro" }, allowSetters = true)
	private Set<Acceso> acceso;
	private static final long serialVersionUID = 1L;

	public Registro() {
		super();
	}

	public Registro(Integer id, Basico persona, Date fecha, Boolean tos, Boolean malestar, Boolean fatiga,
			Boolean nasal, Boolean garganta, Boolean dificultad, Double temperatura, Date fechaReg, Boolean covid,
			Set<Acceso> acceso) {
		super();
		this.id = id;
		this.persona = persona;
		this.fecha = fecha;
		this.tos = tos;
		this.malestar = malestar;
		this.fatiga = fatiga;
		this.nasal = nasal;
		this.garganta = garganta;
		this.dificultad = dificultad;
		this.temperatura = temperatura;
		this.fechaReg = fechaReg;
		this.covid = covid;
		this.acceso = acceso;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", persona=" + persona + ", fecha=" + fecha + ", tos=" + tos + ", malestar="
				+ malestar + ", fatiga=" + fatiga + ", nasal=" + nasal + ", garganta=" + garganta + ", dificultad="
				+ dificultad + ", temperatura=" + temperatura + ", fechaReg=" + fechaReg + ", covid=" + covid
				+ ", acceso=" + acceso + "]";
	}

	public Set<Acceso> getAcceso() {
		return acceso;
	}

	public void setAcceso(Set<Acceso> acceso) {
		this.acceso = acceso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Basico getPersona() {
		return persona;
	}

	public void setPersona(Basico persona) {
		this.persona = persona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getTos() {
		return tos;
	}

	public void setTos(Boolean tos) {
		this.tos = tos;
	}

	public Boolean getMalestar() {
		return malestar;
	}

	public void setMalestar(Boolean malestar) {
		this.malestar = malestar;
	}

	public Boolean getFatiga() {
		return fatiga;
	}

	public void setFatiga(Boolean fatiga) {
		this.fatiga = fatiga;
	}

	public Boolean getNasal() {
		return nasal;
	}

	public void setNasal(Boolean nasal) {
		this.nasal = nasal;
	}

	public Boolean getGarganta() {
		return garganta;
	}

	public void setGarganta(Boolean garganta) {
		this.garganta = garganta;
	}

	public Boolean getDificultad() {
		return dificultad;
	}

	public void setDificultad(Boolean dificultad) {
		this.dificultad = dificultad;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Boolean getCovid() {
		return covid;
	}

	public void setCovid(Boolean covid) {
		this.covid = covid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
