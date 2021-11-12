package com.macro.macroApp.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "manoObra")
public class ManoObra {
	
	@Column(name = "mano_obra_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mano_obra_id;
	
	private String grupo;
	
	private String categoria_ocupacional;
	
	private BigDecimal costo_horario;
	
	private BigDecimal jornada_real;
	
	private String cpc;
	
	private BigDecimal vae;

	
	
	
	
	
	//Get and Set
	public int getMano_obra_id() {
		return mano_obra_id;
	}

	public void setMano_obra_id(int mano_obra_id) {
		this.mano_obra_id = mano_obra_id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCategoria_ocupacional() {
		return categoria_ocupacional;
	}

	public void setCategoria_ocupacional(String categoria_ocupacional) {
		this.categoria_ocupacional = categoria_ocupacional;
	}

	public BigDecimal getCosto_horario() {
		return costo_horario;
	}

	public void setCosto_horario(BigDecimal costo_horario) {
		this.costo_horario = costo_horario;
	}

	public BigDecimal getJornada_real() {
		return jornada_real;
	}

	public void setJornada_real(BigDecimal jornada_real) {
		this.jornada_real = jornada_real;
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
