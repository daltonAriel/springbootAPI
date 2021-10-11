package com.macro.macroApp.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DetalleMaterialID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758694355253699181L;
	private int rubro_id;
	private int material_id;
	
	//Get and Set
	public int getRubro_id() {
		return rubro_id;
	}
	public void setRubro_id(int rubro_id) {
		this.rubro_id = rubro_id;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}
	
	//Hash and Equals
	@Override
	public int hashCode() {
		return Objects.hash(material_id, rubro_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleMaterialID other = (DetalleMaterialID) obj;
		return material_id == other.material_id && rubro_id == other.rubro_id;
	}
	
	
	
}
