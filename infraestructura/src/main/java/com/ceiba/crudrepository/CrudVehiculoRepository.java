package com.ceiba.crudrepository;

import org.springframework.stereotype.Repository;

import com.ceiba.entity.EntityVehiculo;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CrudVehiculoRepository extends CrudRepository<EntityVehiculo, String>{

	
}
