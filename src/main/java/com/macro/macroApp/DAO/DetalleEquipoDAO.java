package com.macro.macroApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.DetalleEquipo;
import com.macro.macroApp.Entity.DetalleEquipoID;

@Repository
public interface DetalleEquipoDAO extends JpaRepository<DetalleEquipo, DetalleEquipoID>{
	
	
	@Query("select dtE from DetalleEquipo dtE where dtE.detalleEquipoID.rubro_id = :id")
	public List<DetalleEquipo> findByRubro_Id(@Param("id") int rubro_id);
	
	@Transactional
	@Modifying
	@Query("delete from DetalleEquipo dtE where dtE.detalleEquipoID.rubro_id = :id")
	public void deleteByRubro_Id(@Param("id") int rubro_id);
}
