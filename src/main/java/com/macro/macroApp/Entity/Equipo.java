package com.macro.macroApp.Entity;

import java.math.BigDecimal;


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
	
	private String descripcion;
	
	private BigDecimal tarifa;
	
	private String cpc;

	private BigDecimal vae;

	
	
	
	//Get and Set
	public int getEquipo_id() {
		return equipo_id;
	}

	public void setEquipo_id(int equipo_id) {
		this.equipo_id = equipo_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getTarifa() {
		return tarifa;
	}

	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
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

	

	
}
