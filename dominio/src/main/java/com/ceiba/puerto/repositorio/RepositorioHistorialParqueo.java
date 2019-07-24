package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;
import com.ceiba.modelo.Vehiculo;

public interface RepositorioHistorialParqueo {

	void crear(HistorialParqueo historialParqueo);

	public RespuestaAlRetirarVehiculo actualizarHistorialAlRetirar(HistorialParqueo historial);

	public HistorialParqueo traerElHistorialParqueo(String placa);

	public boolean existeParqueovehiculo(String placa);

	public boolean consultarSalidaVehiculo(String placa);

	boolean existe(Vehiculo vehiculo);

	public List<HistorialParqueo> consultarVehiculosParqueados();

	public int cantidadVehiculos(String tipo);

}
