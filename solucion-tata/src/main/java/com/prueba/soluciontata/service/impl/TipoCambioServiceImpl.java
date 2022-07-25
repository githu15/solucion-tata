package com.prueba.soluciontata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.soluciontata.dao.ITipoCambioDAO;
import com.prueba.soluciontata.dto.MontoACambiarDto;
import com.prueba.soluciontata.dto.ResponseCambioDto;
import com.prueba.soluciontata.model.TipoCambio;
import com.prueba.soluciontata.service.ITipoCambioService;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService{

	@Autowired
	private ITipoCambioDAO tdao;
	
	@Override
	public List<TipoCambio> listar() {
		return tdao.findAll();
	}

	@Override
	public TipoCambio listarId(Integer id) {
		return tdao.findById(id).orElse(null);
	}

	@Override
	public TipoCambio actualizar(TipoCambio tc) {
		return tdao.save(tc);
	}

	@Override
	public ResponseCambioDto aplicarCambio(MontoACambiarDto mac) {
		TipoCambio tipoc=new TipoCambio();
		tipoc=listarPorMoneda(mac.getMonedaDestino());
		Double nuevoMonto=tipoc.getValorCambio()*mac.getMonto();
		
		ResponseCambioDto cambioDto=new ResponseCambioDto();
		cambioDto.setMontoCambiado(nuevoMonto);
		cambioDto.setTipoCambio(tipoc.getValorCambio());
		cambioDto.setMontoACambiar(mac);
		return cambioDto;
	}

	@Override
	public TipoCambio listarPorMoneda(String moneda) {
		return tdao.listarPorMoneda(moneda);
	}

}
