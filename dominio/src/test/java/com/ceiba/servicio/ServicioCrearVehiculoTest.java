//package com.ceiba.servicio;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//
//import com.ceiba.BasePrueba;
//import com.ceiba.excepcion.ExcepcionExistencia;
//import com.ceiba.excepcion.ExcepcionValoresObligatorios;
//import com.ceiba.modelo.Vehiculo;
//import com.ceiba.puerto.repositorio.RepositorioVehiculo;
//import com.ceiba.testdatabuilder.VehiculoTestBuilder;
//
//public class ServicioCrearVehiculoTest {
//	
//	@Test(expected = ExcepcionExistencia.class)
//	public void validarExistenciaVehiculo() {
//		//Arrange
//		Vehiculo vehiculo = new Vehiculo();
//		vehiculo.setPlaca("NZF73C");
//		
//		RepositorioVehiculo repositorioHistorialP = mock(RepositorioVehiculo.class);
//		ServicioCrearVehiculo CrearVehiculo = new ServicioCrearVehiculo(repositorioHistorialP);
//		//act
//		when(repositorioHistorialP.existe(vehiculo.getPlaca())).thenReturn(true);
//		
//		
//		//  - assert
//		CrearVehiculo.ejecutar(vehiculo);
//	}
//	
//	
//}
