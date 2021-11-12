package com.macro.macroApp.Entity;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidad")
public class Unidad {
	
	@Column(name = "unidad_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unidad_id;
	
	private String nombre;

	//Relaciones 
	
	//@OneToMany(mappedBy = "proyecto" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
	
	@OneToMany(mappedBy = "unidad")
	private Collection<Rubro> rubro = new ArrayList<>();
	
	@OneToMany(mappedBy = "unidad")
	private Collection<Material> material = new ArrayList<>();
	
	@OneToMany(mappedBy = "unidad")
	private Collection<Transporte> transporte = new ArrayList<>();

	
	
	//GET AND SET
	public int getUnidad_id() {
		return unidad_id;
	}

	public void setUnidad_id(int unidad_id) {
		this.unidad_id = unidad_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
