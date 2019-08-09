package com.ceiba.modelo.pago;

import com.ceiba.modelo.TipoVehiculo;

public interface PagoFactory {
	
	public static PagoVehiculo crear(TipoVehiculo tipo, String valorCilindraje) {
		if (tipo == TipoVehiculo.moto) {
			return new PagoMoto(valorCilindraje);			
		} else {
			return new PagoCarro();	
		}
	}

}
