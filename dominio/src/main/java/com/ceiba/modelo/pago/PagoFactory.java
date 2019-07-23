package com.ceiba.modelo.pago;

import com.ceiba.modelo.TipoVehiculo;

public interface PagoFactory {
	
	public static PagoVehiculo crear(String tipo, String valorCilindraje) {
		if (tipo.equals(TipoVehiculo.MOTO)) {
			return new PagoMoto(valorCilindraje);			
		} else {
			return new PagoCarro();	
		}
	}

}
