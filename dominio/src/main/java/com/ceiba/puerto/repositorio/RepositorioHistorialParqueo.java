package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;

public interface RepositorioHistorialParqueo {
	
	void crear(HistorialParqueo historialParqueo);
	
	
	public void actualizarHistorialAlRetirar(HistorialParqueo historial);
	
	
	public HistorialParqueo  traerElHistorialParqueo(String placa);
	
	public boolean  existeParqueovehiculo(String placa);
	
	
	
	public boolean  consultarSalidaVehiculo(String placa);
	

	boolean existe(Vehiculo vehiculo);
	
	
	public List<HistorialParqueo> consultarVehiculosParqueados();
	
	public int cantidadVehiculos(String tipo);

//	void actualizarHistorial(HistorialParqueo historial);
//			/**
//	 * Permite listar los Vehiculos
//	 * @return Vehiculo
//	 */
//	Collection<HistorialParqueo> listar();
//	
//	/**
//	 * Permite crear las peliculas
//	 * @param Vehiculo
//	 */
//	void crear(HistorialParqueo historialParqueo);
//	
//	/**
//	 * Permite determinar si previamente se registro el
//	 * @param Vehiculo
//	 * @return si existe o no
//	 */
//	boolean existe(String placaVehiculo);
//	
//	/**
//	 * Me indicara si dicha historia a registrar ya existe
//	 * 
//	 * */
//	boolean existeHistorial(int id);
//	
//	/**
//	 * Me devolvera la cantidad de vehiculos que hay del tipo que se pase
//	 * sea moto o carro
//	 * */
//	int cantidadVehiculos(String tipo);
//	
//	
//	String devuelveTipo(String placa);
//	
//	int devuelveCilindraje(String placa);
//	
//	public boolean consultarSalidaDeUnVehiculo(String placa);
}
