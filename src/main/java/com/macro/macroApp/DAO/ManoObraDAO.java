package com.macro.macroApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macro.macroApp.Entity.ManoObra;

@Repository
public interface ManoObraDAO extends JpaRepository<ManoObra, Integer>{

}
