package com.ceiba.servicio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;
import com.ceiba.modelo.pago.PagoFactory;
import com.ceiba.modelo.pago.PagoVehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

public class ServicioHistorialParqueaderoSalida {

	private static final String MOTO = "moto";
	private static final String AUTO = "auto";

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
				historial.getVehiculo().getPlaca(), historial.getVehiculo().getTipoVehiculo(),
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

	public float calcularPagoParqueo(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String placa,
			String tipoVehiculo, String valorCilindraje) {
		String tipo = devuelveTipoDeVehiculo(tipoVehiculo);
		PagoVehiculo pagoVehiculo = PagoFactory.crear(tipo, valorCilindraje);
		// template method
		return pagoVehiculo.calcularPago(fechaIngreso, fechaSalida);
	}

	public int obtenerHorasTrascurridas(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {

		long divisorParaConvertirAsegundos = 1000;
		long segundos = (fechaSalida.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli()
				- fechaIngreso.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli())
				/ divisorParaConvertirAsegundos;

		int horas = (int) (segundos / 3600);
		segundos = segundos % 3600;
		int minutos = (int) (segundos / 60);

		if (minutos > 0) {
			horas++;
			return horas;
		}

		segundos = segundos % 60;

		if (segundos > 0 && horas == 0) {
			horas++;
			return horas;
		}
		return horas;

	}

	public String devuelveTipoDeVehiculo(String tipoVehiculo) {
		String tipoAutomovil = tipoVehiculo;
		if (tipoAutomovil.equals(AUTO)) {
			return AUTO;
		} else {
			return MOTO;
		}
	}

	public List<HistorialParqueo> consultarListarVehiculosParqueados() {
		return this.repositorioHistorial.consultarVehiculosParqueados();
	}

}
