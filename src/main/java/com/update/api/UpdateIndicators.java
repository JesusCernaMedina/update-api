package com.update.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/update")
public class UpdateIndicators {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	String sql_metro = "UPDATE metro SET encendido = ?, puntos_activos = ? WHERE numero_id_tarjeta = ?";
	
	@PostMapping("/v1/indicators")
	public ResponseEntity<UpdateBodyResponse> updateIndicators(@RequestBody UpdateDataBody data) {		
		int updateResponse = jdbc.update(sql_metro, data.isEncendido(), data.isPuntosActivos(), data.getNumeroIdTarjeta());
		
		if (updateResponse == 1) {
			return ResponseEntity.ok(new UpdateBodyResponse("indicadores actualizados con exito", "OK"));
		} else {
			return ResponseEntity.ok(new UpdateBodyResponse("Error al actualizar indicadores", "KO"));
		}
	}

}
