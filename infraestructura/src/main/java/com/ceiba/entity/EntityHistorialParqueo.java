package com.ceiba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.ceiba.modelo.Vehiculo;

@Entity(name ="HistorialParqueo")
public class EntityHistorialParqueo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date fechaIngreso;
	private Date fechaSalida;
	private float pago;
	
	@ManyToOne

	@JoinColumn(name = "placa", referencedColumnName = "placa")
	private EntityVehiculo vehiculo;
	
	public EntityHistorialParqueo() {

	}

	

	public EntityHistorialParqueo( Date fechaIngreso, Date fechaSalida, float pago, EntityVehiculo vehiculo) {
	
		
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		this.vehiculo = vehiculo;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
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
