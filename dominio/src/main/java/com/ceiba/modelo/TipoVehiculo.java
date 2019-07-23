package com.ceiba.modelo;

public interface TipoVehiculo {
	static final String MOTO = "moto";
	static final String AUTO = "auto";
	
	static String devuelveTipoDeVehiculo(String tipoVehiculo) {
		String tipoAutomovil = tipoVehiculo;
		if (tipoAutomovil.equals(AUTO)) {
			return AUTO;
		} else {
			return MOTO;
		}
	}
}
