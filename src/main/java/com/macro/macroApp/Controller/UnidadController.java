package com.macro.macroApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macro.macroApp.DAO.UnidadDAO;
import com.macro.macroApp.Entity.Unidad;

@RestController
@RequestMapping("/unidad")
@CrossOrigin(origins = "*")
public class UnidadController {
	
	@Autowired
	private UnidadDAO unidadDAO;
	
	//Obtener todas las unidades
	@GetMapping
	public ResponseEntity<List<Unidad>> getAllUnidades(){
		try {
			List<Unidad> unidades = unidadDAO.findAll();
			return new ResponseEntity<List<Unidad>>(unidades, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Obtener todas las unidades
	@GetMapping("/{id}")
	public ResponseEntity<Unidad> getById(@PathVariable(value =  "id") int id){
		try {
			Optional<Unidad> optionalUnidad = unidadDAO.findById(id);
			if(!optionalUnidad.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<Unidad>(optionalUnidad.get(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Guardar unidad
	@PostMapping()
	public ResponseEntity<Unidad> saveUnidad(@RequestBody Unidad unidad){
		try {
			Unidad newUnidad = unidadDAO.save(unidad);
			return new ResponseEntity<Unidad>(newUnidad, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Actualizar unidad
	@PutMapping("/{id}")
	public ResponseEntity<Unidad> updateUnidad(@PathVariable(value =  "id") int id, @RequestBody Unidad newUnidad){
		try {
			Optional<Unidad> optionalUnidad = unidadDAO.findById(id);
			if(!optionalUnidad.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			Unidad oldUnidad = optionalUnidad.get();
			if(oldUnidad.getUnidad_id() != newUnidad.getUnidad_id()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build(); 
			}
			unidadDAO.save(newUnidad);
			return new ResponseEntity<Unidad>(newUnidad, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Eliminar Unidad
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUnidad(@PathVariable(value =  "id") int id){
		try {
			unidadDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


}
