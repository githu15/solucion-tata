package com.prueba.soluciontata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.soluciontata.dao.ITipoCambioDAO;
import com.prueba.soluciontata.dto.MontoACambiarDto;
import com.prueba.soluciontata.dto.ResponseCambioDto;
import com.prueba.soluciontata.model.TipoCambio;
import com.prueba.soluciontata.service.ITipoCambioService;
import com.prueba.soluciontata.util.Constantes;

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
		
		TipoCambio tipocOri=new TipoCambio();
		tipocOri=listarPorMoneda(mac.getMonedaOrigen());
		
		TipoCambio tipocDest=new TipoCambio();
		tipocDest=listarPorMoneda(mac.getMonedaDestino());
		
		ResponseCambioDto respuesta=realizarTipoCambio(mac,tipocOri, tipocDest);
		
		respuesta.setMontoACambiar(mac);
		return respuesta;
	}

	@Override
	public TipoCambio listarPorMoneda(String moneda) {
		return tdao.listarPorMoneda(moneda);
	}

	public ResponseCambioDto realizarTipoCambio(MontoACambiarDto mac,TipoCambio tipocOri,TipoCambio tipocDest) {
		ResponseCambioDto cambioDto=new ResponseCambioDto();
		Double nuevoMonto=null;
		if(!mac.getMonedaDestino().equals(mac.getMonedaOrigen())) {
			
			switch (mac.getMonedaDestino()) {
			
			case Constantes.MON_DOLARES:
					if(mac.getMonedaOrigen().equals(Constantes.MON_SOLES)) {
						nuevoMonto=mac.getMonto()/tipocDest.getValorCambio();						
					}
					cambioDto.setTipoCambio(tipocDest.getValorCambio());
				break;
				
			case Constantes.MON_SOLES:
				if(mac.getMonedaOrigen().equals(Constantes.MON_DOLARES)) {
					nuevoMonto=mac.getMonto()*tipocOri.getValorCambio();
				}else if(mac.getMonedaOrigen().equals(Constantes.MON_EUROS)){
					nuevoMonto=mac.getMonto()*tipocOri.getValorCambio();
				}
				cambioDto.setTipoCambio(tipocOri.getValorCambio());
			break;			
			
			case Constantes.MON_EUROS:
				if(mac.getMonedaOrigen().equals(Constantes.MON_SOLES)) {
					nuevoMonto=mac.getMonto()/tipocDest.getValorCambio();
				}
				cambioDto.setTipoCambio(tipocDest.getValorCambio());
			break;				

			default:
				break;
			}
		}
		cambioDto.setMontoCambiado((double) Math.round(nuevoMonto*100d)/100);
		
		return cambioDto;		
	}
}
