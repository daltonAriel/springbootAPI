package com.macro.macroApp.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DetalleTransporteID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int rubro_id;
	private int transporte_id;
	
	//GET AND SET
	public int getRubro_id() {
		return rubro_id;
	}
	public void setRubro_id(int rubro_id) {
		this.rubro_id = rubro_id;
	}
	public int getTransporte_id() {
		return transporte_id;
	}
	public void setTransporte_id(int transporte_id) {
		this.transporte_id = transporte_id;
	}
	
	
	//HASH AND EQUALS
	
	@Override
	public int hashCode() {
		return Objects.hash(rubro_id, transporte_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleTransporteID other = (DetalleTransporteID) obj;
		return rubro_id == other.rubro_id && transporte_id == other.transporte_id;
	}
	
	
	
}
