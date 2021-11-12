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
@Table(name = "transporte")
public class Transporte {
	
	@Id
	@Column(name = "transporte_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transporte_id;
	
	private String tipo;
	
	private BigDecimal costo;
	
	private BigDecimal vae;
	
	private String cpc;
	
	private int unidad_id;
	
	
	//Relacion Unidad
	@ManyToOne()
	@MapsId("unidad_id")
	@JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id")
	private Unidad unidad;


	
	//Get and Set
	public int getTransporte_id() {
		return transporte_id;
	}


	public void setTransporte_id(int transporte_id) {
		this.transporte_id = transporte_id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public BigDecimal getCosto() {
		return costo;
	}


	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	

	public BigDecimal getVae() {
		return vae;
	}


	public void setVae(BigDecimal vae) {
		this.vae = vae;
	}


	public String getCpc() {
		return cpc;
	}


	public void setCpc(String cpc) {
		this.cpc = cpc;
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