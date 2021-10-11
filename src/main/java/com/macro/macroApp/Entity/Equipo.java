package com.macro.macroApp.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {
	
	
	@Column(name = "equipo_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int equipo_id;
	
	private String codigo;
	
	private String detalle;
	
	private BigDecimal tarifa;
	
	private String unidad;
	
	private String cpc;

	private BigDecimal vae;
	
	//Get and Set

	public int getEquipo_id() {
		return equipo_id;
	}

	public void setEquipo_id(int equipo_id) {
		this.equipo_id = equipo_id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getTarifa() {
		return this.tarifa.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa.setScale(2, RoundingMode.HALF_UP);
	}

	public String getCpc() {
		return cpc;
	}

	public void setCpc(String cpc) {
		this.cpc = cpc;
	}

	public BigDecimal getVae() {
		return vae.setScale(2, RoundingMode.HALF_UP);
	}

	public void setVae(BigDecimal vae) {
		this.vae = vae.setScale(2, RoundingMode.HALF_UP);
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	

	
}
