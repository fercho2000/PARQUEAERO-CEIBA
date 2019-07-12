package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.servicio.ServicioHistorialParqueo;


@Configuration
public class ServicioBean {
	
	RepositorioHistorialParqueo repositorioHistorial;
	RepositorioVehiculo repositorioVehiculo;

//	Relaciona el servicio con un bean
	@Bean
	public ServicioHistorialParqueo crearServicio(RepositorioHistorialParqueo repositorioHistorial, RepositorioVehiculo repositorioVehiculo) {
	return new ServicioHistorialParqueo(repositorioHistorial,repositorioVehiculo );
	}
//	
}
