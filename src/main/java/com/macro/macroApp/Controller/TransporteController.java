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

import com.macro.macroApp.DAO.TransporteDAO;
import com.macro.macroApp.Entity.Transporte;

@RestController
@RequestMapping("/transporte")
@CrossOrigin(origins = "*")
public class TransporteController {
	
	@Autowired
	private TransporteDAO transporteDAO;
	
	
	
	
	//Obtener todos los transportes
		@GetMapping
		public ResponseEntity<List<Transporte>> getAll(){
			try {
				List<Transporte> transportes = transporteDAO.findAll();
				return new ResponseEntity<List<Transporte>>(transportes, HttpStatus.OK);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		//Obtener transporte por id
		@GetMapping("/{id}")
		public ResponseEntity<Transporte> getById(@PathVariable(value = "id") int id){
			try {
				Optional<Transporte> optionalTransporte = transporteDAO.findById(id);
				if(!optionalTransporte.isPresent()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<Transporte>(optionalTransporte.get(), HttpStatus.OK);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
		//Guardar transporte
		@PostMapping()
		public ResponseEntity<Transporte> saveTransporte(@RequestBody Transporte transporte){
			try {
				Transporte newTransporte = transporteDAO.save(transporte);
				return new ResponseEntity<Transporte>(newTransporte, HttpStatus.CREATED);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}

		
		//Actualizar transporte
		@PutMapping("/{id}")
		public ResponseEntity<Transporte> updateTransporte(@PathVariable(value = "id") int id, @RequestBody Transporte newTransporte){
			try {
				Optional<Transporte> optionalTransporte = transporteDAO.findById(id);
				if(!optionalTransporte.isPresent()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				Transporte oldTransporte = optionalTransporte.get();
				if(oldTransporte.getTransporte_id() != newTransporte.getTransporte_id()) {
					return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
				}
				transporteDAO.save(newTransporte);
				return new ResponseEntity<Transporte>(newTransporte, HttpStatus.OK);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		//Eliminar Transporte
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteTransporte(@PathVariable(value = "id") int id){
			try {
				transporteDAO.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
