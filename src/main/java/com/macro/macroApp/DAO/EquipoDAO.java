package com.macro.macroApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Equipo;

@Repository
public interface EquipoDAO extends JpaRepository<Equipo, Integer>{
	
	
	/*
	@Query(value = "select new com.myApp.app3.EntityInterface.EquipoStatic(eq.equipo_id, eq.nombre, eq.precio) from Equipo  as eq where lower(eq.nombre) like %:nombre%")
	public List<EquipoStatic>findByNombreFilter2(@Param("nombre") String nombre);
	*/
	
	@Query(value = "select * from Equipo as eq where lower(eq.descripcion) like %:cadena% or CAST(eq.tarifa as varchar) like %:cadena% "
			+ "or lower(eq.cpc) like %:cadena% or CAST(eq.vae as varchar) like %:cadena%", nativeQuery = true)
	public List<Equipo> find_filter(@Param("cadena") String cadena);
	
	
}
