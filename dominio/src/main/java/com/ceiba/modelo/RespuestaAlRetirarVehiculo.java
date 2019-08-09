package com.ceiba.modelo;

import java.time.LocalDateTime;

public class RespuestaAlRetirarVehiculo {

	private static final String MENSAJE_NO_HAY_PLACA = "No se encontro la placa";
	private static final String MENSAJE_NO_HAY_TIPO_VEHICULO = "No se encontro el tipo de vehiculo";
	private static final String MENSAJE_NO_HAY_FECHA_INGRESO = "No no hay fecha ingreso";
	private static final String MENSAJE_NO_HAY_FECHA_SALIDA = "No no hay fecha salida";
	private static final String MENSAJE_NO_GENERO_VALOR_PAGO = "Valor no encontrado";
	private TipoVehiculo tipoVehiculo;
	private String placa;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;

	public RespuestaAlRetirarVehiculo(TipoVehiculo tipoVehiculo, String placa, LocalDateTime fechaIngreso,
			LocalDateTime fechaSalida, float pago) {
		
		ValidarArgumentosRespuestaRetirarVehiculo.validarArgumentoPlaca(placa, MENSAJE_NO_HAY_PLACA);
		ValidarArgumentosRespuestaRetirarVehiculo.validarArgumentoTipoVehiculo(tipoVehiculo,
				MENSAJE_NO_HAY_TIPO_VEHICULO);
		ValidarArgumentosRespuestaRetirarVehiculo.validarArgumentoFechaIngreso(fechaIngreso,
				MENSAJE_NO_HAY_FECHA_INGRESO);
		ValidarArgumentosRespuestaRetirarVehiculo.validarArgumentoFechaSalida(fechaSalida, MENSAJE_NO_HAY_FECHA_SALIDA);
		ValidarArgumentosRespuestaRetirarVehiculo.validarArgumentoPago(pago, MENSAJE_NO_GENERO_VALOR_PAGO);

		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public float getPago() {
		return pago;
	}

	public void setPago(float pago) {
		this.pago = pago;
	}

}
