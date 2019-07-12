package com.ceiba.modelo;


import com.ceiba.excepcion.ExcepcionValoresObligatorios;

public class ValidarArgumentosVehiculo {

	private ValidarArgumentosVehiculo() {}

    public static void validarObligatorios(Object placa,Object tipo_vehiculo, Object cilindraje,
    		Object marca, Object modelo ,String mensaje) {
        if (placa == null || tipo_vehiculo == null|| cilindraje == null || marca == null || modelo == null) {
            throw new ExcepcionValoresObligatorios(mensaje);
        }
    }
	
}
