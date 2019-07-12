package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;

@Component
public class ManejadorListarVehiculos {

	private final RepositorioVehiculo repositorioVehiculo;
	
	public ManejadorListarVehiculos(RepositorioVehiculo vehiculo) {
		this.repositorioVehiculo = vehiculo;
	}
	
	public Collection<Vehiculo> ejecutar() {
		return this.repositorioVehiculo.listar();
	}
	
}
