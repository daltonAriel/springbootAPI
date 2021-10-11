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
import org.springframework.web.server.ResponseStatusException;

import com.macro.macroApp.DAO.ProyectoDAO;
import com.macro.macroApp.Entity.Proyecto;


@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {
	
	
	@Autowired
	private ProyectoDAO proyectoDAO;
	
	//Obtener todos los proyectos
	@GetMapping
	public ResponseEntity<List<Proyecto>> getAll(){
		try {
			List<Proyecto> proyectos = proyectoDAO.findAll();
			return new  ResponseEntity<List<Proyecto>>(proyectos, HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Obtener proyecto por id
	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> getById(@PathVariable(value = "id") int id){
		try {
			Optional<Proyecto> optionalProject = proyectoDAO.findById(id);
			if(!optionalProject.isPresent()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Proyecto>(optionalProject.get(), HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Guardar proyecto
	@PostMapping
	public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto){
		try {
			Proyecto newProject = proyectoDAO.save(proyecto);
			return new ResponseEntity<Proyecto>(newProject, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Actualizar proyecto
	@PutMapping("/{id}")
	public ResponseEntity<Proyecto> updateProyecto(@PathVariable(value = "id") int id, @RequestBody Proyecto newProject){
		try {
			Optional<Proyecto> optionalProject = proyectoDAO.findById(id);
			if(!optionalProject.isPresent()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			Proyecto oldProject = optionalProject.get();
			if(newProject.getProyecto_id() != oldProject.getProyecto_id()) {
				throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
			}
		
			newProject.setProyecto_id(id);
			proyectoDAO.save(newProject);
			return new ResponseEntity<Proyecto>(newProject, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Eliminar proyecto
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProyecto(@PathVariable(value = "id") int id){
		try {
			proyectoDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
