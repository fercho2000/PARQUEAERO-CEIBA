package com.ceiba.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.EntityVehiculo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioVehiculo;

@Repository
public class RepositorioVehiculoData implements RepositorioVehiculo {

	
	CrudRepository<EntityVehiculo, String> repositorioCrud;
	
	public RepositorioVehiculoData(CrudRepository<EntityVehiculo, String> repositorioCrud) {
		super();
		this.repositorioCrud = repositorioCrud;
	}



	@Override
	public void crear(Vehiculo vehiculo) {

		EntityVehiculo vehiculoEntidad = new EntityVehiculo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(), vehiculo.getMarca(), vehiculo.getModelo());
				this.repositorioCrud.save(vehiculoEntidad);

	}



}
