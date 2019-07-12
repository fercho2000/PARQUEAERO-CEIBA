package com.ceiba.repositorio;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.crudrepository.CrudVehiculoRepository;
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
	public Collection<Vehiculo> listar() {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Vehiculo vehiculo) {

		EntityVehiculo vehiculoEntidad = new EntityVehiculo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(), vehiculo.getMarca(), vehiculo.getModelo());
				this.repositorioCrud.save(vehiculoEntidad);

	}

	@Override
	public boolean existe(String placa) {
		// TODO Auto-generated method stub
		return false;
	}

}
