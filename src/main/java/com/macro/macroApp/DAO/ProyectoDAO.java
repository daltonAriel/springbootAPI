package com.macro.macroApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Proyecto;

@Repository
public interface ProyectoDAO extends JpaRepository<Proyecto, Integer>{

}
