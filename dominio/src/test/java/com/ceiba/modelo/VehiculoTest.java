package com.ceiba.modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.ceiba.testdatabuilder.VehiculoTestBuilder;

public class VehiculoTest {
	private static final String PLACA = "afr32bt";
	private static final String TODOS_LOS_DATOS_OBLIGATORIOS = "Todos los datos son obligatorio.";
	private static final String MENSAJE_SI_PLACAS_INCORRECTAS = "La placa que ingreso es incorrecta";
	private static final String CILINDRAJE = "200";
	private static final String TIPO_MOTO = "MOTO";
	private static final String MARCA = "BOXER";
	private static final String MODELO = "2011";

	@Test
	public void validarLongitudPlacaEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca(PLACA).conCilindraje(CILINDRAJE)
				.conMarca(MARCA).conModelo(MODELO).conTipoVehiculo(TIPO_MOTO);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_SI_PLACAS_INCORRECTAS, e.getMessage());
		}

	}

	@Test
	public void validarArgumentosVaciosEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca(null).conCilindraje(null)
				.conMarca(null).conModelo(null).conTipoVehiculo(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(TODOS_LOS_DATOS_OBLIGATORIOS, e.getMessage());
		}

	}

}
