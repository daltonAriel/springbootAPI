package com.macro.macroApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Unidad;

@Repository
public interface UnidadDAO extends JpaRepository<Unidad, Integer> {

}
