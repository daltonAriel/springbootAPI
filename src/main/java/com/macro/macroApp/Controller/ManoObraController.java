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

import com.macro.macroApp.DAO.ManoObraDAO;
import com.macro.macroApp.Entity.ManoObra;

@RestController
@RequestMapping("/mano-obra")
@CrossOrigin(origins = "*")
public class ManoObraController {
	
	@Autowired
	private ManoObraDAO manoObraDAO;
	
	
	
	//Obtener todos registros de mano de obra
	@GetMapping()
	public ResponseEntity<List<ManoObra>> getAll(){
		try {
			List<ManoObra> listaManoObra = manoObraDAO.findAll();
			return new ResponseEntity<List<ManoObra>>(listaManoObra, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Obtener el registro por id
	@GetMapping("/{id}")
	public ResponseEntity<ManoObra> getById(@PathVariable(value = "id") int id){
		try {
			Optional<ManoObra> OptionalManoObra = manoObraDAO.findById(id);
			if(!OptionalManoObra.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<ManoObra>(OptionalManoObra.get(), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Guardar mano obra
	@PostMapping()
	public ResponseEntity<ManoObra> saveManoObra(@RequestBody ManoObra manoObra){
		try {
			ManoObra newManoObra = manoObraDAO.save(manoObra);
			return new ResponseEntity<ManoObra>(newManoObra, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Actualizar mano obra
	@PutMapping("/{id}")
	public ResponseEntity<ManoObra> updateManoObra(@PathVariable(value = "id") int id, @RequestBody ManoObra newManoObra){
		try {
			Optional<ManoObra> optionalManoObra = manoObraDAO.findById(id);
			if(!optionalManoObra.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			ManoObra oldManoObra = optionalManoObra.get();
			if(oldManoObra.getMano_obra_id() != newManoObra.getMano_obra_id()) {
				return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
			}
			manoObraDAO.save(newManoObra);
			return new ResponseEntity<ManoObra>(newManoObra, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Eliminar mano Obra
	@DeleteMapping("/{id}")
	public ResponseEntity<ManoObra> deleteManoObra(@PathVariable(value = "id") int id){
		try {
			manoObraDAO.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
