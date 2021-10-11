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
@Table(name = "material")
public class Material {

	@Column(name = "material_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int material_id;
	
	private String codigo;
	
	private String detalle;
	
	private BigDecimal costo;
	
	private String unidad;
	
	private String cpc;
	
	private BigDecimal vae;

	
	//Get and Set
	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public BigDecimal getCosto() {
		return costo.setScale(2, RoundingMode.HALF_UP);
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo.setScale(2, RoundingMode.HALF_UP);
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
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
	
}
