package com.ceiba.modelo;

import java.time.LocalDateTime;

public class HistorialParqueo {


	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;
	private Vehiculo vehiculo;

	
	public HistorialParqueo() {

	}

	public HistorialParqueo(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, float pago, Vehiculo vehiculo) {

		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		this.vehiculo = vehiculo;
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
