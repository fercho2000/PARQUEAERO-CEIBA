package com.ceiba.repositorio.crudrepository;

import org.springframework.stereotype.Repository;

import com.ceiba.repositorio.entity.EntityVehiculo;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CrudVehiculoRepository extends CrudRepository<EntityVehiculo, String>{

	
}
