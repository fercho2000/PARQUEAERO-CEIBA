package com.ceiba.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name ="HistorialParqueo")
public class EntityHistorialParqueo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;
	
	@ManyToOne

	@JoinColumn(name = "placa", referencedColumnName = "placa")
	private EntityVehiculo vehiculo;
	
	public EntityHistorialParqueo() {

	}

	public EntityHistorialParqueo( LocalDateTime fechaIngreso, LocalDateTime fechaSalida, float pago,
			EntityVehiculo vehiculo) {
	
	
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		this.vehiculo = vehiculo;
	}

	public int getId() {
		return id;
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

	public EntityVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(EntityVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	
}
