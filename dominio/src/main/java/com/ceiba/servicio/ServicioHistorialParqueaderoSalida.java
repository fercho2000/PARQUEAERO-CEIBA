package com.ceiba.servicio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

public class ServicioHistorialParqueaderoSalida {

	private static final float VALOR_HORA_AUTO = 1000;
	private static final float VALOR_HORA_MOTO = 500;
	private static final float VALOR_DIA_AUTO = 8000;
	private static final float VALOR_DIA_MOTO = 4000;
	private static final float VALOR_CILINDRAJE = 2000;
	private static final float MINIMAS_HORAS = 9;
	private static final int HORAS_DIA = 24;
	private static final int CILINDRAJE_MAXIMO = 500;
	private static final String MOTO = "moto";
	private static final String AUTO = "auto";

	private RepositorioHistorialParqueo repositorioHistorial;

	public ServicioHistorialParqueaderoSalida() {
	}

	public ServicioHistorialParqueaderoSalida(RepositorioHistorialParqueo repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}

	public void ejecutarRetirarParqueo(HistorialParqueo historial) {

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

		this.repositorioHistorial.actualizarHistorialAlRetirar(historial);
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
		float pago = 0;
		int cilindraje = Integer.parseInt(valorCilindraje);

		String tipo = devuelveTipoDeVehiculo(tipoVehiculo);
		int horas = obtenerHorasTrascurridas(fechaIngreso, fechaSalida);

		if (tipo.equals(MOTO)) {

			if (cilindraje > CILINDRAJE_MAXIMO) {
				pago = pago + VALOR_CILINDRAJE;
			}

			if (horas < MINIMAS_HORAS) {
				return pago + (VALOR_HORA_MOTO * horas);
			} else {

				if (horas <= HORAS_DIA) {
					return pago + VALOR_DIA_MOTO;
				}

				int dias = (horas / HORAS_DIA);
				horas = horas % HORAS_DIA;

				if (horas < MINIMAS_HORAS) {
					pago = pago + (horas * VALOR_HORA_MOTO);
				} else {
					pago = pago + VALOR_DIA_MOTO;
				}

				pago = pago + (dias * VALOR_DIA_MOTO);

				return pago;
			}

		} else {

			if (horas < MINIMAS_HORAS) {
				return pago + (VALOR_HORA_AUTO * horas);
			} else if (horas <= HORAS_DIA) {
				return pago + VALOR_DIA_AUTO;
			} else {
				int dias = (horas / HORAS_DIA);
				horas = horas % HORAS_DIA;
				if (horas < MINIMAS_HORAS) {
					pago = pago + (horas * VALOR_HORA_AUTO);
				} else {
					pago = pago + VALOR_DIA_AUTO;
				}

				pago = pago + (dias * VALOR_DIA_AUTO);

				return pago;
			}

		}

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
