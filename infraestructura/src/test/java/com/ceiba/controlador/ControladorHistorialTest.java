package com.ceiba.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.comando.manejador.ComandoVehiculo;
import com.ceiba.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorHistorialTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;
	
	
	@Test
	public void testGuardarYListar() throws Exception {
		// arrange
		
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().build();

		// act - assert
		mocMvc.perform(post("/registrarHistorial").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo))).andExpect(status().isOk());

		// act - assert
		mocMvc.perform(get("/obtenervehiculos").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].vehiculo.placa", is(comandoVehiculo.getPlaca())));
	}

	@Test
	public void tesCrearHistorialYgenerarSalidaHistorial() throws Exception {
		// arrange
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoTestDataBuilder().conPlaca("NZDFER").build();

		// act - assert
		mocMvc.perform(post("/registrarHistorial").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo))).andExpect(status().isOk());

		// // arrange

		// // act - assert
		mocMvc.perform(put("/retirar/" + comandoVehiculo.getPlaca()).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(comandoVehiculo.getPlaca()))).andExpect(status().isOk());
	}



}
