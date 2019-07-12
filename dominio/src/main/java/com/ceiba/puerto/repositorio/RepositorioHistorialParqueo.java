package com.ceiba.puerto.repositorio;

import java.util.Collection;

import com.ceiba.modelo.HistorialParqueo;

public interface RepositorioHistorialParqueo {

	void actualizarHistorial(HistorialParqueo historial);
	
	 HistorialParqueo obtenerHistorialParqueo(String placa);
			/**
	 * Permite listar los Vehiculos
	 * @return Vehiculo
	 */
	Collection<HistorialParqueo> listar();
	
	/**
	 * Permite crear las peliculas
	 * @param Vehiculo
	 */
	void crear(HistorialParqueo historialParqueo);
	
	/**
	 * Permite determinar si previamente se registro el
	 * @param Vehiculo
	 * @return si existe o no
	 */
	boolean existe(String placaVehiculo);
	
	/**
	 * Me indicara si dicha historia a registrar ya existe
	 * 
	 * */
	boolean existeHistorial(int id);
	
	/**
	 * Me devolvera la cantidad de vehiculos que hay del tipo que se pase
	 * sea moto o carro
	 * */
	int cantidadVehiculos(String tipo);
	
	
	String devuelveTipo(String placa);
	
	int devuelveCilindraje(String placa);
}
