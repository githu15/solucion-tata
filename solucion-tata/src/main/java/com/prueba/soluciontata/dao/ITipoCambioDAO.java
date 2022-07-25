package com.prueba.soluciontata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prueba.soluciontata.model.TipoCambio;

@Repository
public interface ITipoCambioDAO extends JpaRepository<TipoCambio, Integer>{
	
	@Query(value = "SELECT * FROM TIPO_CAMBIO  WHERE tipo_cambio.tipo_moneda=?1",nativeQuery = true)
	TipoCambio listarPorMoneda(String moneda);
}
