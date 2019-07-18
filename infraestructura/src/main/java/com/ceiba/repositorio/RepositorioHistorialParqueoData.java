package com.ceiba.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ceiba.builderparqueo.MaperHistorialParqueo;
import com.ceiba.crudrepository.CrudHistorialParqueoRepository;
import com.ceiba.entity.EntityHistorialParqueo;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.RespuestaAlRetirarVehiculo;
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
			this.repositorioParqueo.save(MaperHistorialParqueo.convertirAEntidad(historialParqueo));
		} else {
			this.repositorioParqueo.delete(parqueoEntity);
			this.repositorioParqueo.save(MaperHistorialParqueo.convertirAEntidad(historialParqueo));
		}
	}

	@Override
	public RespuestaAlRetirarVehiculo actualizarHistorialAlRetirar(HistorialParqueo historialParqueo) {
		EntityHistorialParqueo parqueoEntity = this.repositorioParqueo
				.findByVehiculoPlaca(historialParqueo.getVehiculo().getPlaca());
		parqueoEntity.setFechaSalida(historialParqueo.getFechaSalida());
		parqueoEntity.setPago(historialParqueo.getPago());
		this.repositorioParqueo.save(parqueoEntity);

		RespuestaAlRetirarVehiculo respuestaSalidaVehiculo = new RespuestaAlRetirarVehiculo(
				historialParqueo.getVehiculo().getTipoVehiculo(), historialParqueo.getVehiculo().getPlaca(),
				historialParqueo.getFechaIngreso(), historialParqueo.getFechaSalida(), historialParqueo.getPago());

		return respuestaSalidaVehiculo;
	}

	@Override
	public HistorialParqueo traerElHistorialParqueo(String placa) {
		EntityHistorialParqueo parqueoEntity = repositorioParqueo.findByVehiculoPlaca(placa);
		return MaperHistorialParqueo.convertirAModelo(parqueoEntity);
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

		if (MaperHistorialParqueo.convertirAModelo(parqueoEntity).getFechaSalida() != null) {
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
			listaParqueo.add(MaperHistorialParqueo.convertirAModelo(parqueoEntity));
		}

		return listaParqueo;
	}

}
