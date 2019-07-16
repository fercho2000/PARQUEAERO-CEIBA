package com.ceiba.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;

import com.ceiba.servicio.ServicioHistorialParqueo;

@Component
public class ManejadorCrearHistorial {

	private final ServicioHistorialParqueo servicioCrearHistorial;

	@Autowired
	public ManejadorCrearHistorial(ServicioHistorialParqueo servicioCrearHistorial) {
		this.servicioCrearHistorial = servicioCrearHistorial;
	}

	public void ejecutar(ComandoVehiculo comandoVehiculo) {

		this.servicioCrearHistorial.ejecutar(new Vehiculo(comandoVehiculo.getPlaca(), comandoVehiculo.getTipoVehiculo(),
				comandoVehiculo.getCilindraje(), comandoVehiculo.getMarca(), comandoVehiculo.getModelo()));

	}

}
