package com.macro.macroApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Equipo;

@Repository
public interface EquipoDAO extends JpaRepository<Equipo, Integer>{

}
