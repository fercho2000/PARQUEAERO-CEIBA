package com.ceiba.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;
import com.ceiba.servicio.ServicioHistorialParqueaderoSalida;

@Component
public class ManejadorSalidaVehiculosHistorial {

	private static final String VEHICULO_NO_ESTA_PARQUEADO = "El vehiculo no esta parqueao";

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

	public RespuestaAlRetirarVehiculo retirarParqueo(HistorialParqueo historialPraqueo) {
		String placa = historialPraqueo.getVehiculo().getPlaca();

		if (!consultarVehiculo(placa)) {
			throw new ExcepcionVehiculoParqueado(VEHICULO_NO_ESTA_PARQUEADO);
		}

		if (consultarSalidaVehiculo(placa)) {
			throw new ExcepcionVehiculoParqueado(VEHICULO_NO_ESTA_PARQUEADO);
		}

		return this.servicioSalidaHistorial.ejecutarRetirarParqueo(historialPraqueo);
	}

	public List<HistorialParqueo> listaDeVehiculosParqueados() {
		return this.servicioSalidaHistorial.consultarListarVehiculosParqueados();
	}

}
