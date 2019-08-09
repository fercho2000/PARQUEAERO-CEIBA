package com.ceiba.testdatabuilder;

import com.ceiba.modelo.TipoVehiculo;
import com.ceiba.modelo.Vehiculo;

public class VehiculoTestBuilder {

	private String placa;
	private TipoVehiculo tipoVehiculo;
	private String cilindraje;
	private String marca;
	private String modelo;	
    
    public VehiculoTestBuilder() {
		placa = "aed585";
		tipoVehiculo = TipoVehiculo.MOTO;
		cilindraje = "600";
		modelo = "2003";
		marca = "pulsar";
	}
    
    public VehiculoTestBuilder conPlaca(String placa) {
    	this.placa = placa;
    	return this;
    }
    
    public VehiculoTestBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
    	this.tipoVehiculo = tipoVehiculo;
    	return this;
    }
    
    public VehiculoTestBuilder conCilindraje(String cilindraje) {
    	this.cilindraje = cilindraje;
    	return this;
    }
    
    public VehiculoTestBuilder conModelo(String modelo) {
    	this.modelo = modelo;    	
    	return this;
    }
    
    public VehiculoTestBuilder conMarca(String marca) {
    	this.marca = marca;
    	return this;
    }
    
    public Vehiculo build() {
    	return new  Vehiculo(placa, tipoVehiculo, cilindraje, marca, modelo) ;
    }
}
