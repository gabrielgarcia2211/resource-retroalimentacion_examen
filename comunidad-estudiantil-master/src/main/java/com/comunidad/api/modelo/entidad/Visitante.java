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
@Table(name = "visitante")
public class Visitante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String documento;
	private String nombre;
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	private Integer eps;
	private String genero;
	@ManyToOne
	@JoinColumn(name = "empresa")
	@JsonIgnoreProperties(value = { "visitante" }, allowSetters = true)
	private Empresa empresa;
	@OneToMany(mappedBy = "visitante", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = { "visitante" }, allowSetters = true)
	private Set<AccesoVisitante> accesoVisitante;
	private static final long serialVersionUID = 1L;

	public Visitante() {
		super();
	}

	public Visitante(Integer id, String documento, String nombre, Date fechaNacimiento, Integer eps, String genero,
			Empresa empresa, Set<AccesoVisitante> accesoVisitante) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.eps = eps;
		this.genero = genero;
		this.empresa = empresa;
		this.accesoVisitante = accesoVisitante;
	}

	@Override
	public String toString() {
		return "Visitante [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", eps=" + eps + ", genero=" + genero + ", empresa=" + empresa
				+ ", accesoVisitante=" + accesoVisitante + "]";
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEps() {
		return eps;
	}

	public void setEps(Integer eps) {
		this.eps = eps;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Set<AccesoVisitante> getAccesoVisitante() {
		return accesoVisitante;
	}

	public void setAccesoVisitante(Set<AccesoVisitante> accesoVisitante) {
		this.accesoVisitante = accesoVisitante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
