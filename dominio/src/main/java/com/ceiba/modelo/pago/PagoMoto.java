package com.ceiba.modelo.pago;

import java.time.LocalDateTime;

public class PagoMoto extends PagoVehiculo {

	private static final float VALOR_DIA_MOTO = 4000;
	private static final float VALOR_HORA_MOTO = 500;
	private static final int CILINDRAJE_MAXIMO = 500;
	private static final float VALOR_CILINDRAJE = 2000;
	private int cilindraje;

	public PagoMoto(String cilindraje) {
		super();
		this.cilindraje = Integer.parseInt(cilindraje);
	}
	
	@Override
	public float calcularPago(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		float pago = super.calcularPago(fechaIngreso, fechaSalida);
		if (cilindraje > CILINDRAJE_MAXIMO) {
			pago = pago + VALOR_CILINDRAJE;
		}
		return pago;
	}

	@Override
	public float getValorHoras() {
		return VALOR_HORA_MOTO;
	}

	@Override
	public float getValorDia() {
		return VALOR_DIA_MOTO;
	}
 
}
