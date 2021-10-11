package com.macro.macroApp.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Rubro;

@Repository
public interface RubroDAO extends JpaRepository<Rubro, Integer>{
	
	
	// Obtener rubto por id del proyecto
	@Query("select r from Rubro r where r.proyecto_id = :id")
	public List<Rubro> findByProyecto_id(@Param("id") int proyecto_id);
	
	// Obtener cantidad de rubros de un proyecto
	@Query("select MAX(r.orden) from Rubro r where r.proyecto_id = :id")
	public Integer countByProyecto_id(@Param("id") int proyecto_id);
	
}
