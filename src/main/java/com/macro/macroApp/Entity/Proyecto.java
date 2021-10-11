package com.macro.macroApp.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	@Column(name = "proyecto_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proyecto_id;
	
	private String nombre;
	
	private String descripcion;
	
	private Date fecha_creacion;
	
	private BigDecimal indirectos;
	
	private boolean estado;
	
	//Relacion rubro
	@OneToMany(mappedBy = "proyecto" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<Rubro> rubro = new ArrayList<>();

	
	//Get and Set
	public int getProyecto_id() {
		return proyecto_id;
	}

	public void setProyecto_id(int proyecto_id) {
		this.proyecto_id = proyecto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public BigDecimal getIndirectos() {
		return indirectos.setScale(2, RoundingMode.HALF_UP);
	}

	public void setIndirectos(BigDecimal indirectos) {
		this.indirectos = indirectos.setScale(2, RoundingMode.HALF_UP);
	}




}
