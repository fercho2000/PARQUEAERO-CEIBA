package com.ceiba.repositorio.repositorioimplementacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.repositorio.builderparqueo.MaperVehiculo;
import com.ceiba.repositorio.entity.EntityVehiculo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;

@Repository
public class RepositorioVehiculoData implements RepositorioVehiculo {

	CrudRepository<EntityVehiculo, String> repositorioCrud;

	public RepositorioVehiculoData(CrudRepository<EntityVehiculo, String> repositorioCrud) {
		
		this.repositorioCrud = repositorioCrud;
	}

	@Override
	public void crear(Vehiculo vehiculo) {

		this.repositorioCrud.save(MaperVehiculo.convertirAEntidad(vehiculo));

	}

}
