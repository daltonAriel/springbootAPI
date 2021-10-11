package com.macro.macroApp.Entity;


import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "detalleManoObraID")
public class DetalleManoObra {
	
	@EmbeddedId
	private DetalleManoObraID detalleManoObraID = new DetalleManoObraID();
	
	private BigDecimal cantidad;
	
	private BigDecimal costo_horario;
	
	private BigDecimal jornada_real;
	
	
	private BigDecimal vae;
	
	//Relaciones
	@ManyToOne
	@MapsId("rubro_id")
	@JoinColumn(name = "rubro_id")
	private Rubro rubro;
	
	@ManyToOne
	@MapsId("mano_obra_id")
	@JoinColumn(name = "mano_obra_id")
	private ManoObra mano_obra;

	//Get and Set
	public DetalleManoObraID getDetalleManoObraID() {
		return detalleManoObraID;
	}

	public void setDetalleManoObraID(DetalleManoObraID detalleManoObraID) {
		this.detalleManoObraID = detalleManoObraID;
	}

	public BigDecimal getCantidad() {
		return cantidad.setScale(2, RoundingMode.HALF_UP);
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getCosto_horario() {
		return costo_horario.setScale(2, RoundingMode.HALF_UP);
	}

	public void setCosto_horario(BigDecimal costo_horario) {
		this.costo_horario = costo_horario.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getJornada_real() {
		return jornada_real.setScale(2, RoundingMode.HALF_UP);
	}

	public void setJornada_real(BigDecimal jornada_real) {
		this.jornada_real = jornada_real.setScale(2, RoundingMode.HALF_UP);
	}


	public BigDecimal getVae() {
		return vae.setScale(2, RoundingMode.HALF_UP);
	}

	public void setVae(BigDecimal vae) {
		this.vae = vae.setScale(2, RoundingMode.HALF_UP);
	}
/*
	public Rubro getRubro() {
		return rubro;
	}
*/
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public ManoObra getMano_obra() {
		return mano_obra;
	}

	public void setMano_obra(ManoObra mano_obra) {
		this.mano_obra = mano_obra;
	}


	
}
