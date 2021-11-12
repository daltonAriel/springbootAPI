package com.macro.macroApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.Transporte;

@Repository
public interface TransporteDAO extends JpaRepository<Transporte, Integer>{

}
