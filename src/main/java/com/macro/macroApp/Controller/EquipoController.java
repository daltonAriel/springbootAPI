package com.macro.macroApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macro.macroApp.DAO.EquipoDAO;
import com.macro.macroApp.Entity.Equipo;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	private EquipoDAO equipoDAO;
	
	
	//Obtener todos los equipos
	@GetMapping()
	public ResponseEntity<List<Equipo>> getAll(){
		try {
			List<Equipo> equipos = equipoDAO.findAll();
			return new ResponseEntity<List<Equipo>>(equipos, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Obtener equipo por id
	@GetMapping("/{id}")
	public ResponseEntity<Equipo> getById(@PathVariable(value = "id") int id){
		try {
			Optional<Equipo> optionalEquipo = equipoDAO.findById(id);
			if(!optionalEquipo.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<Equipo>(optionalEquipo.get(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Guardar equipo
	@PostMapping()
	public ResponseEntity<Equipo> saveEquipo(@RequestBody Equipo equipo){
		try {
			Equipo newEquipo = equipoDAO.save(equipo);
			return new ResponseEntity<Equipo>(newEquipo, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Actualizar equipo
	@PutMapping("/{id}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable(value = "id") int id, @RequestBody Equipo newEquipo){
		try {
			Optional<Equipo> optionalEquipo = equipoDAO.findById(id);
			if(!optionalEquipo.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			Equipo oldEquipo = optionalEquipo.get();
			if(oldEquipo.getEquipo_id() != newEquipo.getEquipo_id()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}
			equipoDAO.save(newEquipo);
			return new ResponseEntity<Equipo>(newEquipo, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//EliminarEquipo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEquipo(@PathVariable(value = "id") int id){
		try {
			equipoDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	
	
	
	
	
}
