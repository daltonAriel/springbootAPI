package com.macro.macroApp.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;


@Entity
@Table(name = "rubro")
@Immutable
public class Rubro {
	
	@Column(name = "rubro_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rubro_id;
	
	private String nombre;
	
	private String observaciones;
	
	private BigDecimal cantidad;
	
	private BigDecimal rendimiento;
	
	private int proyecto_id;
	
	private int unidad_id;
	
	private int orden;

	//Relacion proyecto
	@ManyToOne()
	@MapsId("proyecto_id")
	@JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id")
	private Proyecto proyecto;
	
	
	//Relacion unidad
	@ManyToOne()
	@MapsId("unidad_id")
	@JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id")
	private Unidad unidad;
	
	
	
	//Relaciones detalle -> equipo - manoObra - material - transporte

	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleEquipo> detalleEquipo = new ArrayList<>();
	
	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleManoObra> detalleManoObra = new ArrayList<>();
	
	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleMaterial> detalleMaterial = new ArrayList<>();

	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleTransporte> detalleTransporte = new ArrayList<>();

	
	
	
	
	
	//Get and Set
	public int getRubro_id() {
		return rubro_id;
	}

	public void setRubro_id(int rubro_id) {
		this.rubro_id = rubro_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}

	public int getProyecto_id() {
		return proyecto_id;
	}

	public void setProyecto_id(int proyecto_id) {
		this.proyecto_id = proyecto_id;
	}

	public int getUnidad_id() {
		return unidad_id;
	}

	public void setUnidad_id(int unidad_id) {
		this.unidad_id = unidad_id;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public Unidad getUnidad() {
		return unidad;
	}
/*
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
*/

	


}
