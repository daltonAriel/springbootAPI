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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "detalleMaterialID")
public class DetalleMaterial {
	
	@EmbeddedId
	private DetalleMaterialID detalleMaterialID = new DetalleMaterialID();
	
	private BigDecimal cantidad;
	
	private BigDecimal costo;
	
	private BigDecimal vae;
	
	
	//Relciones
	@ManyToOne
	@MapsId("rubro_id")
	@JoinColumn(name = "rubro_id")
	private Rubro rubro;
	
	@ManyToOne
	@MapsId("material_id")
	@JoinColumn(name = "material_id")
	private Material material;

	
	
	//Get and Set
	public DetalleMaterialID getDetalleMaterialID() {
		return detalleMaterialID;
	}

	public void setDetalleMaterialID(DetalleMaterialID detalleMaterialID) {
		this.detalleMaterialID = detalleMaterialID;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	

	

	
}
