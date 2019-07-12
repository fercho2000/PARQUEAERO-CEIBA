package com.ceiba.puerto.repositorio;

import java.util.Collection;


import com.ceiba.modelo.Vehiculo;

public interface RepositorioVehiculo {

	/**
	 * Permite listar los Vehiculos
	 * @return Vehiculo
	 */
	Collection<Vehiculo> listar();
	
	/**
	 * Permite crear las peliculas
	 * @param Vehiculo
	 */
	void crear(Vehiculo vehiculo);
	
	/**
	 * Permite determinar si previamente se registro el
	 * @param Vehiculo
	 * @return si existe o no
	 */
	boolean existe(String placa);
	
}
