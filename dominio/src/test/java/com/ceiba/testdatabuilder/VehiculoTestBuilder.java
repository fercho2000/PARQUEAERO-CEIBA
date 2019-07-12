package com.ceiba.testdatabuilder;

import com.ceiba.modelo.Vehiculo;

public class VehiculoTestBuilder {

	private String placa;
	private String tipo; 
	private String cilindraje;
	private String modelo;
	private String marca;	
    
    public VehiculoTestBuilder() {
		placa = "aed585";
		tipo = "auto";
		cilindraje = "500";
		modelo = "j21";
		marca = "yamaha";
	}
    
    public VehiculoTestBuilder conPlaca(String placa) {
    	this.placa = placa;
    	return this;
    }
    
    public VehiculoTestBuilder conTipo(String tipo) {
    	this.tipo = tipo;
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
    	return new  Vehiculo(placa, tipo, cilindraje, marca, modelo) ;
    }
}
