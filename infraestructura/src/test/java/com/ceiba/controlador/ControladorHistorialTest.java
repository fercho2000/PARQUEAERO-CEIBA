package com.ceiba.controlador;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;


public class ControladorHistorialTest {
	
	@Autowired
	RepositorioVehiculo vehiculoRepo;
	
	@Autowired
	RepositorioHistorialParqueo historialRepo;
	

	@Test
	public void verificarIngreso() {
		
		// arrange
//		ServicioHistorialParqueo servicio = new ServicioHistorialParqueo(historialRepo, vehiculoRepo);
//		
//		Vehiculo vehiculo = new Vehiculo("ABC123", --);
//		
//		servicio.ejecutar(vehiculo);
//		
//		vehiculoConsulta = servicio.consultarVehiculo("ABC123");
//		
//		AssertTrue(vehiculoConsulta.getPlaca(), "ABC123");
		
	}

}
