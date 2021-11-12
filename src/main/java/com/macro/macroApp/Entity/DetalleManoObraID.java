package com.macro.macroApp.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DetalleManoObraID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1941982509327780323L;
	
	private int rubro_id;
	
	private int mano_obra_id;
	
	
	//Get and Set
	public int getRubro_id() {
		return rubro_id;
	}
	public void setRubro_id(int rubro_id) {
		this.rubro_id = rubro_id;
	}
	public int getMano_obra_id() {
		return mano_obra_id;
	}
	public void setMano_obra_id(int mano_obra_id) {
		this.mano_obra_id = mano_obra_id;
	}
	
	
	//Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(mano_obra_id, rubro_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleManoObraID other = (DetalleManoObraID) obj;
		return mano_obra_id == other.mano_obra_id && rubro_id == other.rubro_id;
	}
	

	
	
}
