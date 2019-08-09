package com.ceiba.testdatabuilder;

import com.ceiba.comando.manejador.ComandoVehiculo;
import com.ceiba.modelo.TipoVehiculo;

public class ComandoVehiculoTestDataBuilder {

	private String placa;
	private TipoVehiculo tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;

	public ComandoVehiculoTestDataBuilder() {
		this.placa = "NZF73C";
		this.tipoVehiculo = TipoVehiculo.MOTO;
		this.cilindraje = "220";
		this.marca = "pulsar";
		this.modelo = "2011";
	}

	public ComandoVehiculoTestDataBuilder conPlaca(String placa) {

		this.placa = placa;
		return this;
	}

	public ComandoVehiculoTestDataBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {

		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public ComandoVehiculoTestDataBuilder conCilindraje(String cilindraje) {

		this.cilindraje = cilindraje;
		return this;
	}
	
	public ComandoVehiculoTestDataBuilder conMarca(String marca) {

		this.marca = marca;
		return this;
	}
	
	public ComandoVehiculoTestDataBuilder conModelo(String modelo) {

		this.modelo = modelo;
		return this;
	}
	
	public ComandoVehiculo build() {
		
		return new ComandoVehiculo( placa,  tipoVehiculo,  cilindraje,  marca,  modelo);
	}
}
