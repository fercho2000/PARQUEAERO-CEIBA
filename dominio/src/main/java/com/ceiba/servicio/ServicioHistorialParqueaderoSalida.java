package com.ceiba.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.excepcion.ExcepcionNoExisteId;
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
	private final static String NO_EXISTE_UN_REGISTRO_CON_ESE_ID = "No existe un registro con este id";

	private RepositorioHistorialParqueo repositorioHistorial;

	public ServicioHistorialParqueaderoSalida() {
	}

	public ServicioHistorialParqueaderoSalida(RepositorioHistorialParqueo repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}

	public void ejecutarparqueo(HistorialParqueo historial) {
		
		float valorTotalAPagar =0;
//		validarExistenciaHistorial(historial.getId());
		Date fechaSalida = historial.getFechaSalida();
		if (fechaSalida == null) {
			fechaSalida = new Date();
		}
		 valorTotalAPagar = calcularPagoParqueo(historial.getFechaIngreso(), fechaSalida, historial.getVehiculo().getPlaca(),
				historial.getVehiculo().getTipoVehiculo());

		historial.setPago(valorTotalAPagar);
		historial.setFechaSalida(fechaSalida);
		
		 this.repositorioHistorial.actualizarHistorial(historial);
	}

	private void validarExistenciaHistorial(int id) {
		boolean existe = this.repositorioHistorial.existeHistorial(id);
		if (!existe) {
			throw new ExcepcionNoExisteId(NO_EXISTE_UN_REGISTRO_CON_ESE_ID);
		}
	}

	public float calcularPagoParqueo(Date fechaIngreso, Date fechaSalida, String placa, String tipoVehiculo) {
		float pago = 0;

		int cilindraje = this.repositorioHistorial.devuelveCilindraje(placa);
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
	
	public HistorialParqueo obtenerHistorialParqueo(String placaVehiculo) {
		return this.repositorioHistorial.obtenerHistorialParqueo(placaVehiculo);
	}

	public int obtenerHorasTrascurridas(Date fechaIngreso, Date fechaSalida) {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
		DateFormat formatoHora = new SimpleDateFormat("HH");
//	        
//	        dateFormat.format(fechaIngreso);
//	        dateFormat.format(fechaSalida);
//	       formatoHora.format( dateFormat.format(fechaIngreso)).toString();
		// damos formato en yyyy-MM-dd H:m:s y luego a horas y calculamos diferencia

		int cantidadHorasInicio = Integer.parseInt(formatoHora.format(fechaIngreso));
		int cantidadHorasFin = Integer.parseInt(formatoHora.format(fechaSalida));
		int diferencia = cantidadHorasInicio - cantidadHorasFin;

		return diferencia;

	}

	public String devuelveTipoDeVehiculo(String tipoVehiculo) {
		String tipoAutomovil = tipoVehiculo;
		if (tipoAutomovil == AUTO) {
			return AUTO;
		} else {
			return MOTO;
		}
	}

}
