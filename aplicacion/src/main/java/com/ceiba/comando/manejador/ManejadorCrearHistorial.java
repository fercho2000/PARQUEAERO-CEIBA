package com.ceiba.comando.manejador;



import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;

import com.ceiba.servicio.ServicioHistorialParqueo;

@Component
public class ManejadorCrearHistorial {

	private final ServicioHistorialParqueo servicioCrearHistorial;

	public ManejadorCrearHistorial(ServicioHistorialParqueo servicioCrearHistorial) {
		this.servicioCrearHistorial = servicioCrearHistorial;
	}

	public void ejecutar(Vehiculo vehiculo) {

		this.servicioCrearHistorial.ejecutar(vehiculo);

	}

}
