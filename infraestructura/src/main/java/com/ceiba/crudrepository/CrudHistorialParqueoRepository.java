package com.ceiba.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entity.EntityHistorialParqueo;

@Repository
public interface CrudHistorialParqueoRepository extends CrudRepository<EntityHistorialParqueo, Integer> {

	public EntityHistorialParqueo findByVehiculoPlaca(String placa);

	public Iterable<EntityHistorialParqueo> findByFechaSalidaNotNull();

	public Iterable<EntityHistorialParqueo> findByVehiculoTipovehiculo(String tipo);

	public Iterable<EntityHistorialParqueo> findAll();

	public void deleteById(Long id);

}
