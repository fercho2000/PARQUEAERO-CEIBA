package com.ceiba.modelo.pago;

public class PagoCarro extends PagoVehiculo {

	private static final float VALOR_DIA_AUTO = 8000;
	private static final float VALOR_HORA_AUTO = 1000;
	
	@Override
	public float getValorHoras() {
		return VALOR_HORA_AUTO;
	}

	@Override
	public float getValorDia() {
		return VALOR_DIA_AUTO;
	}
 
}
