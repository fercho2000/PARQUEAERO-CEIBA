package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ComandoVehiculo;
import com.ceiba.comando.manejador.ManejadorCrearHistorial;
import com.ceiba.comando.manejador.ManejadorSalidaVehiculosHistorial;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;

@RestController
@CrossOrigin(origins = "*")
public class ControladorHistorialParqueo {

	private final ManejadorCrearHistorial manejadorCrearHistorialVehiculo;
	private final ManejadorSalidaVehiculosHistorial manejadorSalidas;

	@Autowired
	public ControladorHistorialParqueo(ManejadorCrearHistorial manejadorCrearHistorialVehiculo,
			ManejadorSalidaVehiculosHistorial manejadorSalidas) {
		this.manejadorCrearHistorialVehiculo = manejadorCrearHistorialVehiculo;
		this.manejadorSalidas = manejadorSalidas;
	}

	@PostMapping("/registrarHistorial")
	public void crearHistorialParqueadero(@RequestBody ComandoVehiculo comandoVehiculo) {
		this.manejadorCrearHistorialVehiculo.ejecutar(comandoVehiculo);
	}

	@GetMapping("/obtenervehiculos")
	public List<HistorialParqueo> consultarVehiculosParqueados() {
		return this.manejadorSalidas.listaDeVehiculosParqueados();
	}

	@PutMapping("/retirar/{placa}")
	public RespuestaAlRetirarVehiculo sacarVehiculo(@PathVariable String placa) {
		HistorialParqueo historialParqueo;
		historialParqueo = this.manejadorSalidas.obtenerParqueo(placa);
		return this.manejadorSalidas.retirarParqueo(historialParqueo);
	}
}
