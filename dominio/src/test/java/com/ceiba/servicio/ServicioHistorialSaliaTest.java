package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.time.LocalDateTime;
import org.junit.Test;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.testdatabuilder.VehiculoTestBuilder;

public class ServicioHistorialSaliaTest {

	private static final String PLACA = "NZF73C";
	private static final String PLACA_AUTO = "NGD125";
	private static final String TIPO_VEHICULO_ES_MOTO = "moto";
	private static final String TIPO_VEHICULO_ES_AUTO = "auto";
	private static final String CILINDRAJE_BAJO = "220";
	private static final String CILINDRAJE_ALTO = "520";

	@Test
	public void obtenerHorasTranscurridas48HorasTest() {
		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(2);
		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		int cantidadHoras = salidaParqueadero.obtenerHorasTrascurridas(fechaIngreso, fechaSalida);

		// assert
		assertEquals(cantidadHoras, 48);
	}

	@Test
	public void obtenerHorasTranscurridas30SegundosTest() {
		// arranges
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusSeconds(30);
		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		int cantidadHoras = salidaParqueadero.obtenerHorasTrascurridas(fechaIngreso, fechaSalida);

		// assert
		assertEquals(cantidadHoras, 1);
	}

	@Test
	public void obtenerHorasTranscurridas8HorasCon35minTest() {
		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(8).plusMinutes(35);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		int cantidadHoras = salidaParqueadero.obtenerHorasTrascurridas(fechaIngreso, fechaSalida);

		// assert
		assertEquals(cantidadHoras, 9);
	}

	@Test
	public void obtenerHorasTranscurridas0SegundosTest() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now();

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		int cantidadHoras = salidaParqueadero.obtenerHorasTrascurridas(fechaIngreso, fechaSalida);

		// assert
		assertEquals(cantidadHoras, 0);
	}

	@Test
	public void calcularValorPago1DiaMotoConCilindrajeBajoTest() {
		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);

		Vehiculo vehiculo = new VehiculoTestBuilder().build();
		vehiculo.setPlaca(PLACA);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_MOTO);
		vehiculo.setCilindraje(CILINDRAJE_BAJO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);

		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago, 4000, 0.001);
	}

	@Test
	public void calcularValorPago1DiaMotoConCilindrajeAltoTest() {
		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);

		Vehiculo vehiculo = new VehiculoTestBuilder().build();
		vehiculo.setPlaca(PLACA);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_MOTO);
		vehiculo.setCilindraje(CILINDRAJE_ALTO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);

		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago, 6000, 0.001);
	}
	
	
	@Test
	public void calcularValorPago3DiaMotoConCilindrajeAltoTest() {
		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(3);

		Vehiculo vehiculo = new VehiculoTestBuilder().build();
		vehiculo.setPlaca(PLACA);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_MOTO);
		vehiculo.setCilindraje(CILINDRAJE_ALTO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);

		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago,14000, 0.001);
	}

	@Test
	public void calcularValorPago1DiaAutoTest() {
		// arrange

		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);
		Vehiculo vehiculo = new VehiculoTestBuilder().build();

		vehiculo.setPlaca(PLACA_AUTO);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_AUTO);
		vehiculo.setCilindraje(CILINDRAJE_ALTO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago, 8000, 0.001);
	}
	
	
	@Test
	public void calcularValorPago1DiaCon2horasAutoTest() {
		// arrange

		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1).plusHours(2);
		Vehiculo vehiculo = new VehiculoTestBuilder().build();

		vehiculo.setPlaca(PLACA_AUTO);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_AUTO);
		vehiculo.setCilindraje(CILINDRAJE_ALTO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago, 10000, 0.001);
	}
	
	@Test
	public void calcularValorPago2DiasAutoTest() {
		// arrange

		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(2);
		Vehiculo vehiculo = new VehiculoTestBuilder().build();

		vehiculo.setPlaca(PLACA_AUTO);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO_ES_AUTO);
		vehiculo.setCilindraje(CILINDRAJE_ALTO);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida salidaParqueadero = new ServicioHistorialParqueaderoSalida(
				repositorioHistorialP);
		// act
		float valorPago = salidaParqueadero.calcularPagoParqueo(fechaIngreso, fechaSalida, vehiculo.getPlaca(),
				vehiculo.getTipoVehiculo(), vehiculo.getCilindraje());

		// assert
		assertEquals(valorPago, 16000, 0.001);
	}

}
