package com.ceiba.modelo;

import com.ceiba.excepcion.ExcepcionArgumentosEsperadosEnSalida;

public class ValidarArgumentosRespuestaRetirarVehiculo {
	
	private ValidarArgumentosRespuestaRetirarVehiculo(){}

	public static void validarArgumentoPlaca(Object placa , String mensaje) {
		if (placa == null ) {
			throw new ExcepcionArgumentosEsperadosEnSalida(mensaje);
		}
	}
	
	public static void validarArgumentoTipoVehiculo(Object tipoVehiculo , String mensaje) {
		if (tipoVehiculo == null ) {
			throw new ExcepcionArgumentosEsperadosEnSalida(mensaje);
		}
	}
	
	public static void validarArgumentoFechaIngreso(Object fechaIngreso , String mensaje) {
		if (fechaIngreso == null ) {
			throw new ExcepcionArgumentosEsperadosEnSalida(mensaje);
		}
	}
	
	
	public static void validarArgumentoFechaSalida(Object fechaSalida , String mensaje) {
		if (fechaSalida == null ) {
			throw new ExcepcionArgumentosEsperadosEnSalida(mensaje);
		}
		
	}
	
	public static void validarArgumentoPago(Object pago , String mensaje) {
		if (pago == null ) {
			throw new ExcepcionArgumentosEsperadosEnSalida(mensaje);
		}
		
		
	}
}
