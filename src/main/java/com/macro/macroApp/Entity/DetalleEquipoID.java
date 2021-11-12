package com.macro.macroApp.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DetalleEquipoID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8575587731905181002L;
	private int rubro_id;
	private int equipo_id;
	
	
	
	//Get and Set
	public int getRubro_id() {
		return rubro_id;
	}
	public void setRubro_id(int rubro_id) {
		this.rubro_id = rubro_id;
	}
	public int getEquipo_id() {
		return equipo_id;
	}
	public void setEquipo_id(int equipo_id) {
		this.equipo_id = equipo_id;
	}
	
	
	
	
	//Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(equipo_id, rubro_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleEquipoID other = (DetalleEquipoID) obj;
		return equipo_id == other.equipo_id && rubro_id == other.rubro_id;
	}

	
}
