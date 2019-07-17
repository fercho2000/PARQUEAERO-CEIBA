package com.ceiba.servicio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import org.junit.Test;
import com.ceiba.excepcion.ExcepcionCantidadVehiculos;
import com.ceiba.excepcion.ExcepcionRestriccionDia;
import com.ceiba.excepcion.ExcepcionTipoVehiculoInvalido;
import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.testdatabuilder.VehiculoTestBuilder;

public class ServicioCrearHistorialTest {

	private static final String PLACA = "afr32b";
	private static final String TIPO_VEHICULO_ES_MOTO = "moto";
	private static final String TIPO_VEHICULO_ES_AUTO = "auto";
	private static final int MAXIMO_CUPOS_MOTO = 11;
	private static final int MAXIMO_CUPOS_AUTO = 21;
	private static final String PROBAR_TIPO_VEHICULO = "noesUnVehiculo";
	private static final DayOfWeek EL_DIA_DE_HOY = DayOfWeek.SUNDAY;

	@Test(expected = ExcepcionVehiculoParqueado.class)
	public void valiarExistenciaDelVehiculoEnParqueadero() {

		// Arrange
		HistorialParqueo historialP = new HistorialParqueo();
		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA).build();

		historialP.setVehiculo(vehiculo);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);

		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP,
				repositorioVehiculo);
		// act

		historialP.setFechaSalida(null);

		when(repositorioHistorialP.traerElHistorialParqueo(historialP.getVehiculo().getPlaca())).thenReturn(historialP);

		// - assert
		crearHistorial.ejecutar(vehiculo);
	}

	@Test(expected = ExcepcionCantidadVehiculos.class)
	public void valiarCuposDisponiblesParaMoto() {

		// Arrange

		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(TIPO_VEHICULO_ES_MOTO).build();

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP,
				repositorioVehiculo);
		// act

		when(repositorioHistorialP.cantidadVehiculos(vehiculo.getTipoVehiculo())).thenReturn(MAXIMO_CUPOS_MOTO);

		// - assert
		crearHistorial.ejecutar(vehiculo);
	}

	@Test(expected = ExcepcionCantidadVehiculos.class)
	public void valiarCuposDisponiblesParaAuto() {

		// Arrange

		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(TIPO_VEHICULO_ES_AUTO).build();

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP,
				repositorioVehiculo);
		// act

		when(repositorioHistorialP.cantidadVehiculos(vehiculo.getTipoVehiculo())).thenReturn(MAXIMO_CUPOS_AUTO);

		// - assert
		crearHistorial.ejecutar(vehiculo);
	}

	@Test(expected = ExcepcionRestriccionDia.class)
	public void valiarPlacaDelAutoParaDiaHabil() {

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP,
				repositorioVehiculo);

		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA).build();
		// -- assert
		crearHistorial.validarPlacaParaDiasHabiles(vehiculo.getPlaca(), EL_DIA_DE_HOY);
	}

	@Test(expected = ExcepcionTipoVehiculoInvalido.class)
	public void valiarTipoVehiculoInvalido() {

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP,
				repositorioVehiculo);

		Vehiculo vehiculo = new VehiculoTestBuilder().conTipoVehiculo(PROBAR_TIPO_VEHICULO).build();
		// -- assert
		crearHistorial.devuelveTipoDeVehiculo(vehiculo.getTipoVehiculo());
	}

}
