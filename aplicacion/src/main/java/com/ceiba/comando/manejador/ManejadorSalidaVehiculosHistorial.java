package com.ceiba.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.servicio.ServicioHistorialParqueaderoSalida;

@Component
public class ManejadorSalidaVehiculosHistorial {

	private final ServicioHistorialParqueaderoSalida servicioSalidaHistorial;

	public ManejadorSalidaVehiculosHistorial(ServicioHistorialParqueaderoSalida servicioSalidaHistorial) {
		this.servicioSalidaHistorial = servicioSalidaHistorial;
	}
	
	public boolean consultarVehiculo(String placa) {
		return this.servicioSalidaHistorial.consultarVehiculo(placa);
	}

	public boolean consultarSalidaVehiculo(String placa) {
		return this.servicioSalidaHistorial.consultarSalidaVehiculo(placa);
	}
	
	public HistorialParqueo obtenerParqueo(String placaVehiculo) {
		return this.servicioSalidaHistorial.obtenerHistorialParqueo(placaVehiculo);
	}
	
	
	public void retirarParqueo(HistorialParqueo historialPraqueo) {
		this.servicioSalidaHistorial.ejecutarRetirarParqueo(historialPraqueo);
	}
	
	public List<HistorialParqueo> consultarVehiculosParqueados() {
		return this.servicioSalidaHistorial.consultarVehiculosParqueados();
	}
	
}
