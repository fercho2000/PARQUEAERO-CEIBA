package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.servicio.ServicioHistorialParqueaderoSalida;

@Component
public class ManejadorSalidaVehiculosHistorial {

	private final ServicioHistorialParqueaderoSalida servicioSalidaHistorial;

	public ManejadorSalidaVehiculosHistorial(ServicioHistorialParqueaderoSalida servicioSalidaHistorial) {
		this.servicioSalidaHistorial = servicioSalidaHistorial;
	}

	public void retirarVehiculo(HistorialParqueo historialParqueo) {
		
		this.servicioSalidaHistorial.ejecutarparqueo(historialParqueo);
	}

	public HistorialParqueo obtenerParqueo(String placaVehiculo) {
		return this.servicioSalidaHistorial.obtenerHistorialParqueo(placaVehiculo);
	}
	
}
