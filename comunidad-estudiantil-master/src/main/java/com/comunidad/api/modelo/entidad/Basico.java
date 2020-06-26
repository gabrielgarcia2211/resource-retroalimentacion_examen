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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "basico")
public class Basico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String documento;
	private String nombre;
	private String telefono;
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	private String genero;
	@ManyToOne
	@JoinColumn(name = "eps")
	@JsonIgnoreProperties(value = { "basico" }, allowSetters = true)
	private Eps eps;
	@ManyToOne
	@JoinColumn(name = "modalidad")
	@JsonIgnoreProperties(value = { "basico" }, allowSetters = true)
	private Modalidad modalidad;
	@ManyToOne
	@JoinColumn(name = "tipo")
	@JsonIgnoreProperties(value = { "basico" }, allowSetters = true)
	private Tipo tipo;
	private Boolean embarazo;
	@Column(name = "contactonombre")
	private String contactoNombre;
	@Column(name = "contactotelefono")
	private String contactoTelefono;
	private Boolean mas60;
	private Boolean menos15;
	private Boolean salud;
	@Column(name = "fechareg")
	private Date fechaReg;
	@OneToOne(mappedBy = "id", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "id" }, allowSetters = true)
	Cormobilidad cormobilidad;
	@OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "persona" }, allowSetters = true)
	Set<Registro> registro;
	private static final long serialVersionUID = 1L;

	public Basico() {
		super();
	}

	public Basico(Integer id, String documento, String nombre, String telefono, Date fechaNacimiento, String genero,
			Eps eps, Modalidad modalidad, Tipo tipo, Boolean embarazo, String contactoNombre, String contactoTelefono,
			Boolean mas60, Boolean menos15, Boolean salud, Date fechaReg, Cormobilidad cormobilidad,
			Set<Registro> registro) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.eps = eps;
		this.modalidad = modalidad;
		this.tipo = tipo;
		this.embarazo = embarazo;
		this.contactoNombre = contactoNombre;
		this.contactoTelefono = contactoTelefono;
		this.mas60 = mas60;
		this.menos15 = menos15;
		this.salud = salud;
		this.fechaReg = fechaReg;
		this.cormobilidad = cormobilidad;
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Basico [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", eps=" + eps + ", modalidad="
				+ modalidad + ", tipo=" + tipo + ", embarazo=" + embarazo + ", contactoNombre=" + contactoNombre
				+ ", contactoTelefono=" + contactoTelefono + ", mas60=" + mas60 + ", menos15=" + menos15 + ", salud="
				+ salud + ", fechaReg=" + fechaReg + ", cormobilidad=" + cormobilidad + ", registro=" + registro + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Boolean getEmbarazo() {
		return embarazo;
	}

	public void setEmbarazo(Boolean embarazo) {
		this.embarazo = embarazo;
	}

	public String getContactoNombre() {
		return contactoNombre;
	}

	public void setContactoNombre(String contactoNombre) {
		this.contactoNombre = contactoNombre;
	}

	public String getContactoTelefono() {
		return contactoTelefono;
	}

	public void setContactoTelefono(String contactoTelefono) {
		this.contactoTelefono = contactoTelefono;
	}

	public Boolean getMas60() {
		return mas60;
	}

	public void setMas60(Boolean mas60) {
		this.mas60 = mas60;
	}

	public Boolean getMenos15() {
		return menos15;
	}

	public void setMenos15(Boolean menos15) {
		this.menos15 = menos15;
	}

	public Boolean getSalud() {
		return salud;
	}

	public void setSalud(Boolean salud) {
		this.salud = salud;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Cormobilidad getCormobilidad() {
		return cormobilidad;
	}

	public void setCormobilidad(Cormobilidad cormobilidad) {
		this.cormobilidad = cormobilidad;
	}

	public Set<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(Set<Registro> registro) {
		this.registro = registro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
