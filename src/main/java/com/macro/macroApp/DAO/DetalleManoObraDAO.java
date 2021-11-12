package com.macro.macroApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.DetalleManoObra;
import com.macro.macroApp.Entity.DetalleManoObraID;

@Repository
public interface DetalleManoObraDAO extends JpaRepository<DetalleManoObra, DetalleManoObraID>{

	
	@Query("select dtMO from DetalleManoObra dtMO where dtMO.detalleManoObraID.rubro_id = :id")
	public List<DetalleManoObra> findByRubro_Id(@Param("id") int rubro_id);
	
	
	
	@Transactional
	@Modifying
	@Query("delete from DetalleManoObra dtMO where dtMO.detalleManoObraID.rubro_id = :id")
	public void deleteByRubro_Id(@Param("id") int rubro_id);
	
}
