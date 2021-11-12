package com.macro.macroApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macro.macroApp.DAO.DetalleManoObraDAO;
import com.macro.macroApp.Entity.DetalleManoObra;

@RestController
@RequestMapping("/detalle-mano-obra")
@CrossOrigin(origins = "*")
public class DetalleManoObraController {

	
	@Autowired
	private DetalleManoObraDAO detalleManoObraDAO;
	
	
	
	
	//obtener todos los detalle-ManoObra de un rubro especifico
	@GetMapping("/rubro/{rubro_id}")
	public ResponseEntity<List<DetalleManoObra>> getAll(@PathVariable(value = "rubro_id") int rubro_id){
		try {
			List<DetalleManoObra> listaDetalleManoObra = detalleManoObraDAO.findByRubro_Id(rubro_id);
			return new ResponseEntity<List<DetalleManoObra>>(listaDetalleManoObra, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	/*
	 * Para guardar los cambios el requestBody es de tipo List donde se encontraran los objetos que 
	 * seran almacenados (en este caso devoveremos solo la respuesta http dependiendo del estado), para 
	 * cualquier operacion de actualizacion se procedera a eliminar todo el contenido de detalle y se 
	 * guardara todo nuevamente.
	 */
	
	
	@PostMapping("/rubro/{rubro_id}")
	public ResponseEntity<?> saveListaDetalleManoOBra(@PathVariable(value = "rubro_id") int rubro_id, @RequestBody List<DetalleManoObra> listaDetalleManoObra){
		try {
			detalleManoObraDAO.deleteByRubro_Id(rubro_id);
			detalleManoObraDAO.saveAll(listaDetalleManoObra);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			//**recuparar los items eliminados!
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	
	
	
	
	
}
