package com.prueba.soluciontata.service;

import java.util.List;

import com.prueba.soluciontata.dto.MontoACambiarDto;
import com.prueba.soluciontata.dto.ResponseCambioDto;
import com.prueba.soluciontata.model.TipoCambio;


public interface ITipoCambioService {
	List<TipoCambio> listar();
	TipoCambio listarId(Integer id);
	TipoCambio listarPorMoneda(String moneda);
	TipoCambio actualizar(TipoCambio tc);
	ResponseCambioDto aplicarCambio(MontoACambiarDto mac);
}
