package com.macro.macroApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.DetalleMaterial;
import com.macro.macroApp.Entity.DetalleMaterialID;

@Repository
public interface DetalleMaterialDAO extends JpaRepository<DetalleMaterial, DetalleMaterialID>{
	
	
	@Query("select dtM from DetalleMaterial dtM where dtM.detalleMaterialID.rubro_id = :id")
	public List<DetalleMaterial> findByRubro_Id(@Param("id") int rubro_id);
	
	
	@Transactional
	@Modifying
	@Query("delete from DetalleMaterial dtM where dtM.detalleMaterialID.rubro_id = :id")
	public void deleteByRubro_Id(@Param("id") int rubro_id);
}
