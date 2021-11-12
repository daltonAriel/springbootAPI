package com.macro.macroApp.Entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "detalleEquipoID")
public class DetalleEquipo {
	
	@EmbeddedId
	private DetalleEquipoID detalleEquipoID = new DetalleEquipoID();
	
	private BigDecimal cantidad;
	
	private BigDecimal tarifa;
	
	private BigDecimal vae;
	
	
	//Relaciones
	@ManyToOne
	@MapsId("rubro_id")
	@JoinColumn(name = "rubro_id")
	private Rubro rubro;
	
	@ManyToOne
	@MapsId("equipo_id")
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;

	
	//Get and Set
	public DetalleEquipoID getDetalleEquipoID() {
		return detalleEquipoID;
	}

	public void setDetalleEquipoID(DetalleEquipoID detalleEquipoID) {
		this.detalleEquipoID = detalleEquipoID;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTarifa() {
		return tarifa;
	}

	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}

	public BigDecimal getVae() {
		return vae;
	}

	public void setVae(BigDecimal vae) {
		this.vae = vae;
	}

/*
	public Rubro getRubro() {
		return rubro;
	}
*/
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


}
