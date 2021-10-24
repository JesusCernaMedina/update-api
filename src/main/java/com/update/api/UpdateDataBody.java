package com.update.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateDataBody {
	
	private boolean encendido;
	private boolean puntosActivos;
	private String numeroIdTarjeta;
	
}
