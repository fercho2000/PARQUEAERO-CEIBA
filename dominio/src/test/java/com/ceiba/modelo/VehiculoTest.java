package com.ceiba.modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.ceiba.testdatabuilder.VehiculoTestBuilder;

public class VehiculoTest {
	private static final String PLACA = "afr32bt";
	private static final String MENSAJE_SI_PLACAS_INCORRECTAS = "La longitud de la placa que ingreso es incorrecta";
	private static final String MENSAJE_PLACA_OBLIGATORIO = "La placa es obligatoria.";
	private static final String MENSAJE_TIPO_VEHICULO_OBLIGATORIO = "El tipo de vehiculo es obligatoria.";
	private static final String MENSAJE_CILINDRAJE_OBLIGATORIO = "El cilindraje es obligatorio.";
	private static final String MENSAJE_MARCA_OBLIGATORIO = "La marca es obligatorio.";
	private static final String MENSAJE_MODELO_OBLIGATORIO = "El modelo del vehiculo es obligatorio.";
	private static final String CILINDRAJE = "200";
	private static final String TIPO_MOTO = "MOTO";
	private static final String MARCA = "BOXER";
	private static final String MODELO = "2011";

	@Test
	public void validarArgumentoPlacaVaciaEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conPlaca(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_PLACA_OBLIGATORIO, e.getMessage());
		}

	}

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
	public void validarArgumentoTipoVehiculoVaciaEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conTipoVehiculo(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_TIPO_VEHICULO_OBLIGATORIO, e.getMessage());
		}

	}

	@Test
	public void validarArgumentoCilindrajeVacioEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conCilindraje(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_CILINDRAJE_OBLIGATORIO, e.getMessage());
		}

	}

	@Test
	public void validarArgumentoMarcacioEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conMarca(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_MARCA_OBLIGATORIO, e.getMessage());
		}
	}

	@Test
	public void validarArgumentoModeloEnModeloVehiculo() {
		// Arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().conModelo(null);
		// act
		try {
			vehiculoTestBuilder.build();
		} catch (Exception e) {
			// assert
			assertEquals(MENSAJE_MODELO_OBLIGATORIO, e.getMessage());
		}
	}

}
