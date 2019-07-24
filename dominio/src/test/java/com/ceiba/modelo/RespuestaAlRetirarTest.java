package com.ceiba.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.testdatabuilder.RespuestaAlRetirarTestBuilder;

public class RespuestaAlRetirarTest {

	private static final String MENSAJE_NO_HAY_PLACA = "No se encontro la placa";
	private static final String MENSAJE_NO_HAY_TIPO_VEHICULO = "No se encontro el tipo de vehiculo";
	private static final String MENSAJE_NO_HAY_FECHA_INGRESO = "No no hay fecha ingreso";
	private static final String MENSAJE_NO_HAY_FECHA_SALIDA = "No no hay fecha salida";
	private static final String MENSAJE_NO_GENERO_VALOR_PAGO = "Valor no encontrado";


	@Test
	public void validarArgumentoTipoVehiculoVacioEnRespuestaSalida() {
		// Arrange
		RespuestaAlRetirarTestBuilder respuestaBuild = new RespuestaAlRetirarTestBuilder().conTipoVehiculo(null);

		try {
			respuestaBuild.build();
			// act
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_NO_HAY_TIPO_VEHICULO, e.getMessage());
		}

	}

	@Test
	public void validarArgumentoPlacaVacioEnRespuestaSalida() {
		// Arrange
		RespuestaAlRetirarTestBuilder respuestaBuild = new RespuestaAlRetirarTestBuilder().conPlaca(null);

		try {
			respuestaBuild.build();
			// act
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_NO_HAY_PLACA, e.getMessage());
		}

	}
	
	
	@Test
	public void validarArgumentoFechaIngresoEnRespuestaSalida() {
		// Arrange
		RespuestaAlRetirarTestBuilder respuestaBuild = new RespuestaAlRetirarTestBuilder().conFechaIngreso(null);

		try {
			respuestaBuild.build();
			// act
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_NO_HAY_FECHA_INGRESO, e.getMessage());
		}

	}
	
	@Test
	public void validarArgumentoFechaSalidaEnRespuestaSalida() {
		// Arrange
		RespuestaAlRetirarTestBuilder respuestaBuild = new RespuestaAlRetirarTestBuilder().conFechaSalida(null);

		try {
			respuestaBuild.build();
			// act
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_NO_HAY_FECHA_SALIDA, e.getMessage());
		}

	}
	
	@Test
	public void validarArgumentoPagoEnRespuestaSalida() {
		// Arrange
		RespuestaAlRetirarTestBuilder respuestaBuild = new RespuestaAlRetirarTestBuilder().conPago(0);

		try {
			respuestaBuild.build();
			// act
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_NO_GENERO_VALOR_PAGO, e.getMessage());
		}

	}

}
