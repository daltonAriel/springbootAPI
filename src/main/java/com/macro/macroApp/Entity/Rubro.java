package com.macro.macroApp.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
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


@Entity
@Table(name = "rubro")
public class Rubro {
	
	@Column(name = "rubro_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rubro_id;
	
	private String nombre;
	
	private String descripcion;
	
	private int cantidad;
	
	private BigDecimal rendimiento;
	
	private int proyecto_id;
	
	private int orden;

	//Relacion proyecto
	@ManyToOne()
	@MapsId("proyecto_id")
	@JoinColumn(name = "proyecto_id", referencedColumnName = "proyecto_id")
	private Proyecto proyecto;
	
	
	//Relaciones detalle -> equipo - manoObra - material

	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleEquipo> detalleEquipo = new ArrayList<>();
	
	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleManoObra> detalleManoObra = new ArrayList<>();
	
	@OneToMany(mappedBy = "rubro", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Collection<DetalleMaterial> detalleMaterial = new ArrayList<>();
	

	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getProyecto_id() {
		return proyecto_id;
	}

	public void setProyecto_id(int proyecto_id) {
		this.proyecto_id = proyecto_id;
	}

	public BigDecimal getRendimiento() {
		return rendimiento.setScale(2, RoundingMode.HALF_UP);
	}

	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento.setScale(2, RoundingMode.HALF_UP);
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	
	
}
