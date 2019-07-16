package com.ceiba.modelo;

import com.ceiba.excepcion.ExcepcionLongitudPlaca;
import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosVehiculo {

	private ValidarArgumentosVehiculo() {
	}

	public static void validarObligatorios(Object placa, Object tipoVehiculo, Object cilindraje, Object marca,
			Object modelo, String mensaje) {
		if (placa == null || tipoVehiculo == null || cilindraje == null || marca == null || modelo == null) {
			throw new ExcepcionValoresObligatorios(mensaje);
		}
	}
	
	
    public static void validarLongitudPlaca(String placa,int longitud,String mensaje){
        if(placa.length() !=longitud){
            throw new ExcepcionLongitudPlaca(mensaje);
        }
    }
}
