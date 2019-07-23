package com.ceiba.modelo.pago;

public class PagoFactory {
	
	private static final String MOTO = "moto";
	private static final String AUTO = "auto";
	
	public static PagoVehiculo crear(String tipo, String valorCilindraje) {
		if (tipo.equals(MOTO)) {
			return new PagoMoto(valorCilindraje);			
		} else {
			return new PagoCarro();	
		}
	}

}
