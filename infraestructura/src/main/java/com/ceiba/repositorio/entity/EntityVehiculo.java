package com.ceiba.repositorio.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ceiba.modelo.TipoVehiculo;

@Entity
@Table(name = "Vehiculo")
public class EntityVehiculo  {
	
	@Id
	private String placa;
	
	@Convert(converter = TipoVehiculoConverter.class)
	private TipoVehiculo tipovehiculo;
	
	private String cilindraje;
	private String marca;
	private String modelo;

	public EntityVehiculo() {

	}

	public EntityVehiculo(String placa, TipoVehiculo tipovehiculo, String cilindraje, String marca, String modelo) {

		this.placa = placa;
		this.tipovehiculo = tipovehiculo;
		this.cilindraje = cilindraje;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVehiculo getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(TipoVehiculo tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
