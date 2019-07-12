package com.ceiba.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorCrearHistorial;
import com.ceiba.consulta.manejador.ManejadorListarVehiculos;
import com.ceiba.modelo.Vehiculo;


@RestController
public class ControladorHistorialParqueo {


	private final ManejadorCrearHistorial manejadorCrearHistorialVehiculo;
	private final ManejadorListarVehiculos manejadorListarVehiculo;
	
	
	public ControladorHistorialParqueo(ManejadorCrearHistorial manejadorCrearHistorialVehiculo,
			ManejadorListarVehiculos manejadorListarVehiculo) {
	
		this.manejadorCrearHistorialVehiculo = manejadorCrearHistorialVehiculo;
		this.manejadorListarVehiculo = manejadorListarVehiculo;
	}


	@PostMapping("/historial")
	public void crearHistorialParqueadero(@RequestBody Vehiculo vehiculo) {
		
		System.out.println(vehiculo.getTipoVehiculo());
		
		this.manejadorCrearHistorialVehiculo.ejecutar(vehiculo);
	}
}
