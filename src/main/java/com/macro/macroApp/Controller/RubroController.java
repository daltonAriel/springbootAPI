package com.macro.macroApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macro.macroApp.DAO.RubroDAO;
import com.macro.macroApp.Entity.Rubro;

@RestController
@RequestMapping("/rubro")
@CrossOrigin(origins = "*")
public class RubroController {
	
	
	@Autowired
	private RubroDAO rubroDAO;
	
	//obtener todos los rubros
	/*
	 * Por lo general esta funcion estara desabilitada, ya que no necesitamos obtener todos los
	 * rubros, debemos obtener los rubros de un proyecto especifico mediante su id_proyecto lo
	 * lo mismo se aplicaria en la parte de proyectos
	 *
	@GetMapping
	public ResponseEntity<List<Rubro>> getAll(){
		try {
			List<Rubro> rubros = rubroDAO.findAll();
			return new ResponseEntity<List<Rubro>>(rubros, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	*/
	
	
	//Obtener todos los rubros de un proyecto especifico mediante el id_proyecto**
	@GetMapping("/proyecto/{id}")
	public ResponseEntity<List<Rubro>> getAllByProjectId(@PathVariable(value =  "id") int proyecto_id){
		try {
			List<Rubro> rubros = rubroDAO.findByProyecto_id(proyecto_id);
			return new ResponseEntity<List<Rubro>>(rubros, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Obtener un rubro mediante su id
	@GetMapping("/{id}")
	public ResponseEntity<Rubro> getById(@PathVariable(value =  "id") int id){
		try {
			Optional<Rubro> optionalRubro = rubroDAO.findById(id);
			if(!optionalRubro.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<Rubro>(optionalRubro.get(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//guardar rubro
	@PostMapping("/proyecto/{id}")
	public ResponseEntity<Rubro> setRubro(@PathVariable(value =  "id") int proyecto_id, @RequestBody Rubro rubro){
		try {
			int order = 0;
			if(rubroDAO.countByProyecto_id(proyecto_id) != null) {
				order = rubroDAO.countByProyecto_id(proyecto_id);
			}
			rubro.setOrden(order+1);
			Rubro newRubro = rubroDAO.save(rubro);
			return new ResponseEntity<Rubro>(newRubro, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Actualizar rubro
	@PutMapping("/{id}")
	public ResponseEntity<Rubro> updateRubro(@PathVariable(value =  "id") int id, @RequestBody Rubro newRubro){
		try {
			Optional<Rubro> optionalRubro = rubroDAO.findById(id);
			if(!optionalRubro.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			Rubro oldRubro = optionalRubro.get();
			if(oldRubro.getRubro_id() != newRubro.getRubro_id()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}
			rubroDAO.save(newRubro);
			return new ResponseEntity<Rubro>(newRubro, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Eliminar rubo
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRubro(@PathVariable(value =  "id") int id){
		try {
			rubroDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Actualizar el orden del rubro
	@PatchMapping("/update-order/{id}")
	public ResponseEntity<?> orderRubro(@PathVariable(value = "id") int proyecto_id, @RequestBody List<Rubro> listRubros){
		try {
			int i = 1;
		    for (Rubro rubro :listRubros) {
		    	rubro.setOrden(i);
		    	i++;
		    }
			rubroDAO.saveAll(listRubros);	
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
