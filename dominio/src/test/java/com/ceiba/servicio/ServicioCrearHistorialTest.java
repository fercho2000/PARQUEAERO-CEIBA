//package com.ceiba.servicio;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.time.DayOfWeek;
//import java.time.LocalDateTime;
//
//import org.junit.Test;
//
//import com.ceiba.excepcion.ExcepcionCantidadVehiculos;
//import com.ceiba.excepcion.ExcepcionExistencia;
//import com.ceiba.excepcion.ExcepcionRestriccionDia;
//import com.ceiba.excepcion.ExcepcionVehiculoParqueado;
//import com.ceiba.excepcion.ExepcionTipoVehiculoInvalido;
//import com.ceiba.modelo.HistorialParqueo;
//import com.ceiba.modelo.Vehiculo;
//import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
//
//public class ServicioCrearHistorialTest {
//
//	private static final String PLACA = "afr32b";
//	private static final String TIPO_VEHICULO = "auto";
//	private static final int MAXIMO_CUPOS = 21;
//	private static final String PROBAR_TIPO_VEHICULO = "noesvehiculo";
//	private static final DayOfWeek EL_DIA_DE_HOY = DayOfWeek.SUNDAY;
//
//	@Test(expected = ExcepcionExistencia.class)
//	public void validarExistenciaPreviaHistorial() {
//		// Arrange
//		HistorialParqueo historialP = new HistorialParqueo();
//		historialP.setId(1);
//
//		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
//		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP);
//		// act
//
//		when(repositorioHistorialP.existeHistorial(historialP.getId())).thenReturn(true);
//
//		// - assert
//		crearHistorial.ejecutar(historialP);
//	}
//
//	@Test(expected = ExcepcionVehiculoParqueado.class)
//	public void valiarExistenciaParqueoVehiculo() {
//
//		// Arrange
//		HistorialParqueo historialP = new HistorialParqueo();
//		Vehiculo vehiculo = new Vehiculo();
//		vehiculo.setPlaca(PLACA);
//
//		historialP.setVehiculo(vehiculo);
//
//		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
//		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP);
//		// act
//
//		when(repositorioHistorialP.existe(historialP.getVehiculo().getPlaca())).thenReturn(true);
//
//		// - assert
//		crearHistorial.ejecutar(historialP);
//	}
//
//	@Test(expected = ExcepcionCantidadVehiculos.class)
//	public void valiarCuposDisponiblesVehiculo() {
//
//		// Arrange
//		HistorialParqueo historialP = new HistorialParqueo();
//		Vehiculo vehiculo = new Vehiculo();
//		vehiculo.setTipoVehiculo(TIPO_VEHICULO);
//
//		historialP.setVehiculo(vehiculo);
//
//		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
//		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo(repositorioHistorialP);
//		// act
//
//		when(repositorioHistorialP.cantidadVehiculos(historialP.getVehiculo().getTipoVehiculo()))
//				.thenReturn(MAXIMO_CUPOS);
//
//		// - assert
//		crearHistorial.ejecutar(historialP);
//	}
//
//	@Test(expected = ExcepcionRestriccionDia.class)
//	public void valiarPlacaParaiaHabil() {
//
//		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo();
//		// -- assert
//		crearHistorial.validarPlacaParaDiasHabiles(PLACA, EL_DIA_DE_HOY);
//	}
//
//	@Test(expected = ExepcionTipoVehiculoInvalido.class)
//	public void valiarTipoVehiculoInvalido() {
//
//		ServicioHistorialParqueo crearHistorial = new ServicioHistorialParqueo();
//
//		// -- assert
//		crearHistorial.devuelveTipoDeVehiculo(PROBAR_TIPO_VEHICULO);
//	}
//
//}
