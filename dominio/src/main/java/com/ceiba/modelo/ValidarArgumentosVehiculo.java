package com.ceiba.modelo;

import com.ceiba.excepcion.ExcepcionLongitudPlaca;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosVehiculo {
	
	private ValidarArgumentosVehiculo() {
		
	}

	public static void validarArgumentoPlaca(Object placa , String mensaje) {
		if (placa == null ) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarLongitudPlaca(String placa, int longitud, String mensaje) {
		if (placa.length() != longitud) {
			throw new ExcepcionLongitudPlaca(mensaje);
		}
	}
	
	public static void validarArgumentoTipoVehiculo(Object tipoVehiculo , String mensaje) {
		if (tipoVehiculo == null ) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentoCilindraje(Object cilindraje , String mensaje) {
		if (cilindraje == null ) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	public static void validarArgumentoMarca(Object marca , String mensaje) {
		if (marca == null ) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	

	
	public static void validarArgumentoModelo(Object modelo, String mensaje) {
		if (modelo == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}


}
