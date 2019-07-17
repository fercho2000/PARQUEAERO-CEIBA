package com.ceiba.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ceiba.builderparqueo.BuilderHistorialParqueo;
import com.ceiba.crudrepository.CrudHistorialParqueoRepository;
import com.ceiba.entity.EntityHistorialParqueo;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

@Repository
public class RepositorioHistorialParqueoData implements RepositorioHistorialParqueo {

	CrudHistorialParqueoRepository repositorioParqueo;

	public RepositorioHistorialParqueoData(CrudHistorialParqueoRepository repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}

	@Override
	public void crear(HistorialParqueo historialParqueo) {

		EntityHistorialParqueo parqueoEntity = this.repositorioParqueo
				.findByVehiculoPlaca(historialParqueo.getVehiculo().getPlaca());
		if (parqueoEntity == null) {
			this.repositorioParqueo.save(BuilderHistorialParqueo.convertirAEntidad(historialParqueo));
		} else {
			this.repositorioParqueo.delete(parqueoEntity);
			this.repositorioParqueo.save(BuilderHistorialParqueo.convertirAEntidad(historialParqueo));
		}
	}

	@Override
	public void actualizarHistorialAlRetirar(HistorialParqueo historialParqueo) {
		EntityHistorialParqueo parqueoEntity = this.repositorioParqueo
				.findByVehiculoPlaca(historialParqueo.getVehiculo().getPlaca());
		parqueoEntity.setFechaSalida(historialParqueo.getFechaSalida());
		parqueoEntity.setPago(historialParqueo.getPago());
		this.repositorioParqueo.save(parqueoEntity);
	}

	@Override
	public HistorialParqueo traerElHistorialParqueo(String placa) {
		EntityHistorialParqueo parqueoEntity = repositorioParqueo.findByVehiculoPlaca(placa);
		return BuilderHistorialParqueo.convertirAModelo(parqueoEntity);
	}

	@Override
	public boolean existeParqueovehiculo(String placa) {

		boolean vehiculoExiste = false;

		if (this.repositorioParqueo.findByVehiculoPlaca(placa) != null) {
			vehiculoExiste = true;
		}

		return vehiculoExiste;

	}

	@Override
	public boolean consultarSalidaVehiculo(String placa) {
		boolean vehiculoSalio = false;
		EntityHistorialParqueo parqueoEntity = this.repositorioParqueo.findByVehiculoPlaca(placa);

		if (BuilderHistorialParqueo.convertirAModelo(parqueoEntity).getFechaSalida() != null) {
			vehiculoSalio = true;
		}

		return vehiculoSalio;
	}

	@Override
	public boolean existe(Vehiculo vehiculo) {
		boolean elVehiculoExiste = true;

		if (this.repositorioParqueo.findByVehiculoPlaca(vehiculo.getPlaca()) != null) {

			elVehiculoExiste = true;
		} else {
			elVehiculoExiste = false;
		}

		return elVehiculoExiste;

	}

	@Override
	public int cantidadVehiculos(String tipoVehiculo) {
		int contadorVehiculos = 0;
		Iterable<EntityHistorialParqueo> listaVehiculos = this.repositorioParqueo
				.findByVehiculoTipovehiculo(tipoVehiculo);
		for (EntityHistorialParqueo vehiculo : listaVehiculos) {
			if (vehiculo.getFechaSalida() == null) {
				contadorVehiculos++;
			}
		}
		return contadorVehiculos;
	}

	@Override
	public List<HistorialParqueo> consultarVehiculosParqueados() {

		List<HistorialParqueo> listaParqueo = new ArrayList<>();
		Iterable<EntityHistorialParqueo> listaParqueosEntities = this.repositorioParqueo.findAll();

		for (EntityHistorialParqueo parqueoEntity : listaParqueosEntities) {
			listaParqueo.add(BuilderHistorialParqueo.convertirAModelo(parqueoEntity));
		}

		return listaParqueo;
	}

}
