package com.prueba.soluciontata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Tipo_Cambio")
public class TipoCambio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max=3, message = "Tipo de Moneda debe tener maximo 3 caracteres")
	@Column(name="tipo_moneda", nullable=false)
	private String tipoMoneda;
	
	@Column(name="valor_cambio", nullable=false)
	private Double valorCambio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Double getValorCambio() {
		return valorCambio;
	}

	public void setValorCambio(Double valorCambio) {
		this.valorCambio = valorCambio;
	}
	
	
}
