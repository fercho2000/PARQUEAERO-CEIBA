package com.ceiba.servicio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	public void ejecutarRetirarParqueo(HistorialParqueo historial) {

		float valorTotalAPagar = 0;
		Date fechaSalida = historial.getFechaSalida();
		if (fechaSalida == null) {
			fechaSalida = new Date();
		}
		valorTotalAPagar = calcularPagoParqueo(historial.getFechaIngreso(), fechaSalida,
				historial.getVehiculo().getPlaca(), historial.getVehiculo().getTipoVehiculo(),historial.getVehiculo().getCilindraje());

		historial.setPago(valorTotalAPagar);
		System.out.println("El valor a pagar es : "+valorTotalAPagar);
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
	

	public float calcularPagoParqueo(Date fechaIngreso, Date fechaSalida, String placa, String tipoVehiculo, String valorCilindraje) {
		float pago = 0;

		int cilindraje = Integer.parseInt(valorCilindraje);
		System.out.println("El cilindraje de dicho vehiculo es : "+cilindraje);
		String tipo = devuelveTipoDeVehiculo(tipoVehiculo);
		int horas = obtenerHorasTrascurridas(fechaIngreso, fechaSalida);
	System.out.println("Las horas transcurridas fueron : "+horas);
		if (tipo.equals(MOTO)) {
			if(horas == 0 && cilindraje>CILINDRAJE_MAXIMO) {
				pago=VALOR_HORA_MOTO + VALOR_CILINDRAJE;
			}

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
	


	public int obtenerHorasTrascurridas(Date fechaIngreso, Date fechaSalida) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        
        long milliseconds = fechaIngreso.getTime() - fechaSalida.getTime();
        
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, seconds);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.HOUR_OF_DAY, hours);
         
        System.out.println(" seconds : "+seconds +" minutes : "+minutes +" hours :"+hours);
        return hours;


	}

	public String devuelveTipoDeVehiculo(String tipoVehiculo) {
		String tipoAutomovil = tipoVehiculo;
		if (tipoAutomovil == AUTO) {
			return AUTO;
		} else {
			return MOTO;
		}
	}
	
	
	public List<HistorialParqueo> consultarVehiculosParqueados(){
		return this.repositorioHistorial.consultarVehiculosParqueados();
	}

}
