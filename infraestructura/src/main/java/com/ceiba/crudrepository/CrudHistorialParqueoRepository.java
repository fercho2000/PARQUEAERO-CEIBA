package com.ceiba.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.EntityHistorialParqueo;

@Repository
public interface CrudHistorialParqueoRepository extends CrudRepository<EntityHistorialParqueo, Integer> {

}
