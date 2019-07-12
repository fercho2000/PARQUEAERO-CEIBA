package com.ceiba.modelo;

public class Vehiculo {

	private static final String TODOS_LOS_DATOS_OBLIGATORIOS = "Todos los datos son obligatorio.";

	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;

	public Vehiculo() {

	}

	public Vehiculo(String placa, String tipoVehiculo, String cilindraje, String marca, String modelo) {

		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
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

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
