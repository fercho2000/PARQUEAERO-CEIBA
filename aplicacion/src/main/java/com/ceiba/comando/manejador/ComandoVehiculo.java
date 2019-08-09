package com.ceiba.comando.manejador;

import com.ceiba.modelo.TipoVehiculo;

public class ComandoVehiculo {

	private String placa;
	private TipoVehiculo tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;

	public ComandoVehiculo() {

	}

	public ComandoVehiculo(String placa, TipoVehiculo tipoVehiculo, String cilindraje, String marca, String modelo) {

		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
}
