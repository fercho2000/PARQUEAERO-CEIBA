package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.manejador.ManejadorCrearHistorial;
import com.ceiba.comando.manejador.ManejadorSalidaVehiculosHistorial;
import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;

@RestController
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
	public void crearHistorialParqueadero(@RequestBody Vehiculo vehiculo) {

		this.manejadorCrearHistorialVehiculo.ejecutar(vehiculo);
	}
	
	
	
	@GetMapping("/obtenervehiculos")
	public List<HistorialParqueo> consultarVehiculosParqueados() {
		
	
		
		return this.manejadorSalidas.consultarVehiculosParqueados();
	}

	
	@PutMapping("/retirar/{placa}")
	public void sacarVehiculo(@PathVariable String placa) {

		if(!this.manejadorSalidas.consultarVehiculo(placa)) {
			throw new ExcepcionVehiculoParqueado("El vehiculo no esta parqueao");
		}
		
		if(this.manejadorSalidas.consultarSalidaVehiculo(placa)) {
			throw new ExcepcionVehiculoParqueado("El vehiculo no esta parqueao");
		}
		
	HistorialParqueo historialParqueo;
			
	historialParqueo = this.manejadorSalidas.obtenerParqueo(placa);
			
//							
		this.manejadorSalidas.retirarParqueo(historialParqueo);
	}
}
