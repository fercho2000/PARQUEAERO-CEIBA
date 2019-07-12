package com.ceiba.servicio;

import java.time.DayOfWeek;
import java.util.Date;

import com.ceiba.excepcion.ExcepcionCantidadVehiculos;
import com.ceiba.excepcion.ExcepcionExistencia;
import com.ceiba.excepcion.ExcepcionRestriccionDia;
import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
import com.ceiba.excepcion.ExepcionTipoVehiculoInvalido;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;

import java.time.LocalDateTime;

public class ServicioHistorialParqueo {

	private static final String REGISTRO_EXISTENTE = "Ya se encuentra registrado";
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
		
		
		 //Que el vehiculos
		//Que el vehiculo no existe
		
		this.repositorioVehiculo.crear(vehiculo);
		HistorialParqueo historiaParqueo = new HistorialParqueo(new Date(), null, 0, vehiculo);	
		validarExistenciaPreviaHistorial(historiaParqueo);
		validarVehiculoParqueado(vehiculo.getPlaca());
		validarCupos(historiaParqueo);
		validarPlacaParaDiasHabiles(vehiculo.getPlaca(), LocalDateTime.now().getDayOfWeek());
		
	
		this.repositorioHistorial.crear(historiaParqueo);
	
	}
	
		/*
		
		validarExistenciaPreviaHistorial(historial);
		validarVehiculoParqueado(historial.getVehiculo().getPlaca());
		validarCupos(historial);
		validarPlacaParaDiasHabiles(historial.getVehiculo().getPlaca(), LocalDateTime.now().getDayOfWeek());
		this.repositorioHistorial.crear(historial);
		
	}
	
*/
	private void validarExistenciaPreviaHistorial(HistorialParqueo historial) {
		boolean existe = this.repositorioHistorial.existeHistorial(historial.getId());
		if (existe) {
			throw new ExcepcionExistencia(REGISTRO_EXISTENTE);
		}
	}

	private void validarVehiculoParqueado(String placa) {
		boolean estaParqueado = this.repositorioHistorial.existe(placa);
		if (estaParqueado) {
			throw new ExcepcionVehiculoParqueado(El_VEHICULO_YA_ESTA_PARQUEADO);
		}

	}

	private void validarCupos(HistorialParqueo historial) {
		String tipo = devuelveTipoDeVehiculo(historial.getVehiculo().getTipoVehiculo());
		int cantidadVehiculos = this.repositorioHistorial.cantidadVehiculos(tipo);

		if (tipo.equals(MOTO)) {
			if (cantidadVehiculos > NUMERO_MAXIMO_PARA_MOTO) {
				throw new ExcepcionCantidadVehiculos(NO_HAY_MAS_CUPOS_PARA_MOTO);
			}
		} else if(tipo.equals(AUTO)){
			if (cantidadVehiculos > NUMERO_MAXIMO_PARA_AUTO) {
				throw new ExcepcionCantidadVehiculos(NO_HAY_MAS_CUPOS_PARA_AUTO);
			}
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
		} else if (tipoAutomovil.equals(MOTO)){
			return MOTO;
		}else {
			throw new ExepcionTipoVehiculoInvalido(TIPO_VEHICULO_INCORRECTO);
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
