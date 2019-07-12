package com.ceiba.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorCrearHistorial;
import com.ceiba.comando.manejador.ManejadorSalidaVehiculosHistorial;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;

@RestController
public class ControladorHistorialParqueo {

	private final ManejadorCrearHistorial manejadorCrearHistorialVehiculo;
	private final ManejadorSalidaVehiculosHistorial manejadorSalidas;

	public ControladorHistorialParqueo(ManejadorCrearHistorial manejadorCrearHistorialVehiculo,
			ManejadorSalidaVehiculosHistorial manejadorSalidas) {

		this.manejadorCrearHistorialVehiculo = manejadorCrearHistorialVehiculo;
		this.manejadorSalidas = manejadorSalidas;
	}

	@PostMapping("/registrarHistorial")
	public void crearHistorialParqueadero(@RequestBody Vehiculo vehiculo) {

		this.manejadorCrearHistorialVehiculo.ejecutar(vehiculo);
	}

	@PutMapping("/retirar/{placa}")
	public void sacarVehiculo(@PathVariable String placa) {

		HistorialParqueo historialParqueo;

		historialParqueo = this.manejadorSalidas.obtenerParqueo(placa);
		this.manejadorSalidas.retirarVehiculo(historialParqueo);
	}
}
