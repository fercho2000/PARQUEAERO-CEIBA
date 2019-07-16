package com.ceiba.servicio;

import java.time.DayOfWeek;

import com.ceiba.excepcion.ExcepcionCantidadVehiculos;
import com.ceiba.excepcion.ExcepcionRestriccionDia;
import com.ceiba.excepcion.ExcepcionTipoVehiculoInvalido;
import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;

import java.time.LocalDateTime;

import org.mockito.cglib.core.Local;

public class ServicioHistorialParqueo {

	private static final String NO_HAY_MAS_CUPOS_PARA_MOTO = "No hay más  cupos disponibles para moto";
	private static final String NO_HAY_MAS_CUPOS_PARA_AUTO = "No hay cupos disponibles para autos";
	private static final String NO_PUEDE_INGRESAR_DIA_NO_HABIL = "El vehiculo no puede ingresar, dia no habil";
	private static final String TIPO_VEHICULO_INCORRECTO = "Tipo de vehiculo incorrecto";
	private static final String El_VEHICULO_YA_ESTA_PARQUEADO = "El vehiculo ya esta parqueado";

	private static final String MOTO = "moto";
	private static final String AUTO = "auto";
	private static final String LETRA_A = "a";
	private static final Integer NUMERO_MAXIMO_PARA_AUTO = 20;
	private static final Integer NUMERO_MAXIMO_PARA_MOTO = 10;

	private RepositorioHistorialParqueo repositorioHistorial;
	private RepositorioVehiculo repositorioVehiculo;

	public ServicioHistorialParqueo(RepositorioHistorialParqueo repositorioHistorial,
			RepositorioVehiculo repositorioVehiculo) {

		this.repositorioHistorial = repositorioHistorial;
		this.repositorioVehiculo = repositorioVehiculo;
	}

	public void ejecutar(Vehiculo vehiculo) {
		int totalCobrar = 0;
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaDeSalida = null;
		DayOfWeek elDiaDeHoys = LocalDateTime.now().getDayOfWeek();
		HistorialParqueo historiaParqueo = new HistorialParqueo(fechaIngreso, fechaDeSalida, totalCobrar, vehiculo);

		validarVehiculoParqueado(vehiculo.getPlaca());
		validarCupos(historiaParqueo);
		validarPlacaParaDiasHabiles(vehiculo.getPlaca(), elDiaDeHoys);

		this.repositorioVehiculo.crear(vehiculo);
		this.repositorioHistorial.crear(historiaParqueo);

	}

//	public boolean consultarVehiculo(String placa) {
//		return this.parqueoFachadaInterface.consultarVehiculo(placa);
//	}

	// me verifica si este vehiculo ya se encuentra parqueado

	public void validarVehiculoParqueado(String placa) {

		HistorialParqueo historial = this.repositorioHistorial.traerElHistorialParqueo(placa);

		if (estaParqueado(historial)) {
			throw new ExcepcionVehiculoParqueado(El_VEHICULO_YA_ESTA_PARQUEADO);
		}

	}

	private boolean estaParqueado(HistorialParqueo historial) {
		return historial != null && historial.getFechaSalida() == null;
	}

	public void validarCupos(HistorialParqueo historial) {
		String tipo = devuelveTipoDeVehiculo(historial.getVehiculo().getTipoVehiculo());
		int cantidadVehiculos = this.repositorioHistorial.cantidadVehiculos(tipo);

		if (tipo.equals(MOTO) && cantidadVehiculos > NUMERO_MAXIMO_PARA_MOTO) {
			throw new ExcepcionCantidadVehiculos(NO_HAY_MAS_CUPOS_PARA_MOTO);
		} else if (tipo.equals(AUTO) && cantidadVehiculos > NUMERO_MAXIMO_PARA_AUTO) {

			throw new ExcepcionCantidadVehiculos(NO_HAY_MAS_CUPOS_PARA_AUTO);
		}
	}

	public void validarPlacaParaDiasHabiles(String placa, DayOfWeek eldiaDeHoy) {
		if (validaPrimeraLetra(placa) && hoyEsLunesODomingo(eldiaDeHoy)) {
			throw new ExcepcionRestriccionDia(NO_PUEDE_INGRESAR_DIA_NO_HABIL);
		}
	}

	public String devuelveTipoDeVehiculo(String tipoVehiculo) {
		String tipoAutomovil = tipoVehiculo;
		if (tipoAutomovil.contentEquals(AUTO)) {
			return AUTO;
		} else if (tipoAutomovil.equals(MOTO)) {
			return MOTO;
		} else {
			throw new ExcepcionTipoVehiculoInvalido(TIPO_VEHICULO_INCORRECTO);
		}
	}

	public boolean validaPrimeraLetra(String placa) {
		String primeraLetra = placa.toLowerCase().charAt(0) + "";
		return primeraLetra.equals(LETRA_A);
	}

	public Boolean hoyEsLunesODomingo(DayOfWeek eldiaDeHoy) {
		return eldiaDeHoy.equals(DayOfWeek.MONDAY) || eldiaDeHoy.equals(DayOfWeek.SUNDAY);
	}

}
