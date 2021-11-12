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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "detalleTransporteID")
public class DetalleTransporte {
	
	@EmbeddedId
	private DetalleTransporteID detalleTransporteID = new DetalleTransporteID();
	
	private BigDecimal cantidad;
	
	private BigDecimal costo;
	
	private BigDecimal vae;
	
	//Relciones
	@ManyToOne
	@MapsId("rubro_id")
	@JoinColumn(name = "rubro_id")
	private Rubro rubro;
	
	
	@ManyToOne
	@MapsId("transporte_id")
	@JoinColumn(name = "transporte_id")
	private Transporte transporte;


	//Get and Set
	public DetalleTransporteID getDetalleTransporteID() {
		return detalleTransporteID;
	}


	public void setDetalleTransporteID(DetalleTransporteID detalleTransporteID) {
		this.detalleTransporteID = detalleTransporteID;
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


/*
	public Rubro getRubro() {
		return rubro;
	}
*/


	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}


	public Transporte getTransporte() {
		return transporte;
	}


	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}


	public BigDecimal getCantidad() {
		return cantidad;
	}


	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}




	
}
