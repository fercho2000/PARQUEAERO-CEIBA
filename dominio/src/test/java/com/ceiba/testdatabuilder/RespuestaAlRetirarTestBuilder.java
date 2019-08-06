package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.RespuestaAlRetirarVehiculo;

public class RespuestaAlRetirarTestBuilder {
	private String tipoVehiculo;
	private String placa;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;

	public RespuestaAlRetirarTestBuilder() {
		placa = "aed585";
		tipoVehiculo = "moto";
		fechaIngreso = LocalDateTime.now();
		fechaSalida = LocalDateTime.now().plusDays(1);
		pago = 0;
	}

	public RespuestaAlRetirarTestBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public RespuestaAlRetirarTestBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public RespuestaAlRetirarTestBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;

		return this;
	}

	public RespuestaAlRetirarTestBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;

		return this;
	}

	public RespuestaAlRetirarTestBuilder conPago(float pago) {
		this.pago = pago;

		return this;
	}

	public RespuestaAlRetirarVehiculo build() {
			
		return new RespuestaAlRetirarVehiculo(tipoVehiculo, placa, fechaIngreso, fechaSalida, pago);
	}
	
}