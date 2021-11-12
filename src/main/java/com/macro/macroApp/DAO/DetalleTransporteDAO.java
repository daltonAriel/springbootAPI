package com.macro.macroApp.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.macro.macroApp.Entity.DetalleTransporte;
import com.macro.macroApp.Entity.DetalleTransporteID;

@Repository
public interface DetalleTransporteDAO extends JpaRepository<DetalleTransporte, DetalleTransporteID>{

	
	@Query("select dtT from DetalleTransporte dtT where dtT.detalleTransporteID.rubro_id = :id")
	public List<DetalleTransporte> findByRubro_Id(@Param("id") int rubro_id);
	
	
	
	@Transactional
	@Modifying
	@Query("delete from DetalleTransporte dtT where dtT.detalleTransporteID.rubro_id = :id")
	public void deleteByRubro_Id(@Param("id") int rubro_id);
	
	
}
