package com.macro.macroApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macro.macroApp.DAO.DetalleMaterialDAO;
import com.macro.macroApp.Entity.DetalleMaterial;

@RestController
@RequestMapping("/detalle-material")
public class DetalleMaterialController {

	@Autowired
	private DetalleMaterialDAO detalleMaterialDAO;
	
	
	
	//obtener todos los detalle-material de un rubro especifico
	@GetMapping("/rubro/{rubro_id}")
	public ResponseEntity<List<DetalleMaterial>> getAll(@PathVariable(value = "rubro_id") int rubro_id){
		try {
			List<DetalleMaterial> listaDetalleMatrial = detalleMaterialDAO.findByRubro_Id(rubro_id);
			return new ResponseEntity<List<DetalleMaterial>>(listaDetalleMatrial, HttpStatus.OK);
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
	public ResponseEntity<?> saveListDetalleMaterial(@PathVariable(value = "rubro_id") int rubro_id, @RequestBody List<DetalleMaterial> listaDetalleMatrial){
		try {
			detalleMaterialDAO.deleteByRubro_Id(rubro_id);
			detalleMaterialDAO.saveAll(listaDetalleMatrial);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			//Recuparar datos si existe error!
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
