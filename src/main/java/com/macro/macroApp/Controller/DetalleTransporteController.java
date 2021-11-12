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

import com.macro.macroApp.DAO.DetalleTransporteDAO;
import com.macro.macroApp.Entity.DetalleTransporte;

@RestController
@RequestMapping("/detalle-transporte")
@CrossOrigin(origins = "*")
public class DetalleTransporteController {

	@Autowired
	private DetalleTransporteDAO detalleTransporteDAO;
	

	//obtener todos los detalle-transporte de un rubro especifico
	@GetMapping("/rubro/{rubro_id}")
	public ResponseEntity<List<DetalleTransporte>> getAll(@PathVariable(value = "rubro_id") int rubro_id){
		try {
			List<DetalleTransporte> listaDetalleTransporte = detalleTransporteDAO.findByRubro_Id(rubro_id);
			return new ResponseEntity<List<DetalleTransporte>>(listaDetalleTransporte, HttpStatus.OK);
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
	public ResponseEntity<?> saveListDetalleTransporte(@PathVariable(value = "rubro_id") int rubro_id, @RequestBody List<DetalleTransporte> listaDetalleTransporte){
		try {
			detalleTransporteDAO.deleteByRubro_Id(rubro_id);
			detalleTransporteDAO.saveAll(listaDetalleTransporte);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			//Recuparar datos si existe error!
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	
	
}
