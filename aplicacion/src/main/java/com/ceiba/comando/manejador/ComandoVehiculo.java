package com.ceiba.comando.manejador;

public class ComandoVehiculo {

	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;

	public ComandoVehiculo() {

	}

	public ComandoVehiculo(String placa, String tipoVehiculo, String cilindraje, String marca, String modelo) {

		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipoVehiculo() {
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
