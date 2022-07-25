package com.prueba.soluciontata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.soluciontata.dto.MontoACambiarDto;
import com.prueba.soluciontata.dto.ResponseCambioDto;
import com.prueba.soluciontata.model.TipoCambio;
import com.prueba.soluciontata.service.ITipoCambioService;

@RestController
@RequestMapping(value = "/tipocambio")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService service;
	
	@GetMapping(value = "/listar")
	public List<TipoCambio> listar(){
		return service.listar();
	}
	
	@GetMapping(value="/listarId/{id}")
	public TipoCambio listarId(@PathVariable("id") Integer id){
		return service.listarId(id);
	}
	
	@GetMapping(value="/listarPorMoneda/{moneda}")
	public TipoCambio listarPorMoneda(@PathVariable("moneda") String moneda){
		return service.listarPorMoneda(moneda);
	}
	
	@PostMapping(value="/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public TipoCambio actualizar(@Valid @RequestBody TipoCambio tc){
		return service.actualizar(tc);
	}
	
	@PostMapping(value="/aplicar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCambioDto aplicar(@RequestBody MontoACambiarDto mac){
		return service.aplicarCambio(mac);
	}
}
