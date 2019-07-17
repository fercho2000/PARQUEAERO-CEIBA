package com.ceiba.modelo;

public class Vehiculo {

	private static final int LONGITUD_PLACAS = 6;
	private static final String MENSAJE_SI_PLACAS_INCORRECTAS = "La longitud de la placa que ingreso es incorrecta";
	private static final String MENSAJE_PLACA_OBLIGATORIO = "La placa es obligatoria.";
	private static final String MENSAJE_TIPO_VEHICULO_OBLIGATORIO = "El tipo de vehiculo es obligatoria.";
	private static final String MENSAJE_CILINDRAJE_OBLIGATORIO = "El cilindraje es obligatorio.";
	private static final String MENSAJE_MARCA_OBLIGATORIO = "La marca es obligatorio.";
	private static final String MENSAJE_MODELO_OBLIGATORIO = "El modelo del vehiculo es obligatorio.";

	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;

	public Vehiculo(String placa, String tipoVehiculo, String cilindraje, String marca, String modelo) {

		ValidarArgumentosVehiculo.validarArgumentoPlaca(placa, MENSAJE_PLACA_OBLIGATORIO);
		ValidarArgumentosVehiculo.validarLongitudPlaca(placa, LONGITUD_PLACAS, MENSAJE_SI_PLACAS_INCORRECTAS);

		ValidarArgumentosVehiculo.validarArgumentoTipoVehiculo(tipoVehiculo, MENSAJE_TIPO_VEHICULO_OBLIGATORIO);
		ValidarArgumentosVehiculo.validarArgumentoCilindraje(cilindraje, MENSAJE_CILINDRAJE_OBLIGATORIO);
		ValidarArgumentosVehiculo.validarArgumentoMarca(marca, MENSAJE_MARCA_OBLIGATORIO);
		ValidarArgumentosVehiculo.validarArgumentoModelo(modelo, MENSAJE_MODELO_OBLIGATORIO);
		
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
