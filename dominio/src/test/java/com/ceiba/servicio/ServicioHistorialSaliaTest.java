package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import com.ceiba.excepcion.ExcepcionNoExisteId;
import com.ceiba.excepcion.ExepcionTipoVehiculoInvalido;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

public class ServicioHistorialSaliaTest {

	
	@Test(expected = ExcepcionNoExisteId.class)
	public void validarExistenciaPreviaHistorial() {
		// Arrange
		HistorialParqueo historialP = new HistorialParqueo();
		historialP.setId(1);

		RepositorioHistorialParqueo repositorioHistorialP = mock(RepositorioHistorialParqueo.class);
		ServicioHistorialParqueaderoSalida crearHistorial = new ServicioHistorialParqueaderoSalida(repositorioHistorialP);
		// act

		when(repositorioHistorialP.existeHistorial(historialP.getId())).thenReturn(false);

		// - assert
		crearHistorial.ejecutarparqueo(historialP);
	}
	
	@Test
	public void valiarTipoVehiculoInvalido() {

		ServicioHistorialParqueaderoSalida crearHistorial = new ServicioHistorialParqueaderoSalida();
			Date date = new Date();
		// -- assert
			assertEquals(0, crearHistorial.obtenerHorasTrascurridas(date, date));

	}
	
	

}
