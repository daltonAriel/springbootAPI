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

import com.macro.macroApp.DAO.MaterialDAO;
import com.macro.macroApp.Entity.Material;

@RestController
@RequestMapping("/material")
public class MaterialController {
	
	@Autowired
	private MaterialDAO materialDAO;
	
	
	//Obtener todos los materiales
	@GetMapping
	public ResponseEntity<List<Material>> getAll(){
		try {
			List<Material> materiales = materialDAO.findAll();
			return new ResponseEntity<List<Material>>(materiales, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Obtener material por id
	@GetMapping("/{id}")
	public ResponseEntity<Material> getById(@PathVariable(value = "id") int id){
		try {
			Optional<Material> optionalMaterial = materialDAO.findById(id);
			if(!optionalMaterial.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<Material>(optionalMaterial.get(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Guardar material
	@PostMapping()
	public ResponseEntity<Material> saveProyecto(@RequestBody Material material){
		try {
			Material newMaterial = materialDAO.save(material);
			return new ResponseEntity<Material>(newMaterial, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	//Actualizar matarial
	@PutMapping("/{id}")
	public ResponseEntity<Material> updateMaterial(@PathVariable(value = "id") int id, @RequestBody Material newMaterial){
		try {
			Optional<Material> optionalMaterial = materialDAO.findById(id);
			if(!optionalMaterial.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			Material oldMaterial = optionalMaterial.get();
			if(oldMaterial.getMaterial_id() != newMaterial.getMaterial_id()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}
			materialDAO.save(newMaterial);
			return new ResponseEntity<Material>(newMaterial, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Eliminar Material
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMaterial(@PathVariable(value = "id") int id){
		try {
			materialDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
