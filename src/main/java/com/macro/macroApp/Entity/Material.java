package com.macro.macroApp.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material {

	@Column(name = "material_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int material_id;
	
	private String descripcion;
	
	private BigDecimal costo;
	
	private String cpc;
	
	private BigDecimal vae;

	private int unidad_id;
	
	
	//Relacion unidad
	@ManyToOne()
	@MapsId("unidad_id")
	@JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id")
	private Unidad unidad;

	
	
	//Get and Set
	
	public int getMaterial_id() {
		return material_id;
	}


	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public BigDecimal getCosto() {
		return costo;
	}


	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}


	public String getCpc() {
		return cpc;
	}


	public void setCpc(String cpc) {
		this.cpc = cpc;
	}


	public BigDecimal getVae() {
		return vae;
	}


	public void setVae(BigDecimal vae) {
		this.vae = vae;
	}


	public int getUnidad_id() {
		return unidad_id;
	}


	public void setUnidad_id(int unidad_id) {
		this.unidad_id = unidad_id;
	}


	public Unidad getUnidad() {
		return unidad;
	}


	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	
	
}
