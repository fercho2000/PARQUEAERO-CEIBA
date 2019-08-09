package com.ceiba.servicio;

import java.time.LocalDateTime;
import java.util.List;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;
import com.ceiba.modelo.TipoVehiculo;
import com.ceiba.modelo.pago.PagoFactory;
import com.ceiba.modelo.pago.PagoVehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

public class ServicioHistorialParqueaderoSalida {


	private RepositorioHistorialParqueo repositorioHistorial;

	public ServicioHistorialParqueaderoSalida(RepositorioHistorialParqueo repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}

	public RespuestaAlRetirarVehiculo ejecutarRetirarParqueo(HistorialParqueo historial) {
		
	float valorTotalAPagar = 0;
		LocalDateTime fechaSalida = historial.getFechaSalida();
		if (fechaSalida == null) {
			fechaSalida = LocalDateTime.now();
		}
		valorTotalAPagar = calcularPagoParqueo(historial.getFechaIngreso(), fechaSalida,
				historial.getVehiculo().getTipoVehiculo(),
				historial.getVehiculo().getCilindraje());

		historial.setPago(valorTotalAPagar);
		historial.setFechaSalida(fechaSalida);

		return this.repositorioHistorial.actualizarHistorialAlRetirar(historial);
	}
	
	public HistorialParqueo obtenerHistorialParqueo(String placa) {
		return this.repositorioHistorial.traerElHistorialParqueo(placa);
	}

	public boolean consultarSalidaVehiculo(String placa) {
		return this.repositorioHistorial.consultarSalidaVehiculo(placa);
	}

	public boolean consultarVehiculo(String placa) {
		return this.repositorioHistorial.existeParqueovehiculo(placa);
	}

	public float calcularPagoParqueo(LocalDateTime fechaIngreso, LocalDateTime fechaSalida,
			TipoVehiculo tipoVehiculo, String valorCilindraje) {
		PagoVehiculo pagoVehiculo = PagoFactory.crear(tipoVehiculo, valorCilindraje);
		// template method
		return pagoVehiculo.calcularPago(fechaIngreso, fechaSalida);
	}

	public List<HistorialParqueo> consultarListarVehiculosParqueados() {
		return this.repositorioHistorial.consultarVehiculosParqueados();
	}

}
