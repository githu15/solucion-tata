package com.prueba.soluciontata.dto;

public class ResponseCambioDto {
	private Double montoCambiado;
	private Double tipoCambio;
	
	private MontoACambiarDto montoACambiar;
	
	public Double getMontoCambiado() {
		return montoCambiado;
	}
	public void setMontoCambiado(Double montoCambiado) {
		this.montoCambiado = montoCambiado;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public MontoACambiarDto getMontoACambiar() {
		return montoACambiar;
	}
	public void setMontoACambiar(MontoACambiarDto montoACambiar) {
		this.montoACambiar = montoACambiar;
	}

	
}
