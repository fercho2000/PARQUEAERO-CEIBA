package com.ceiba.repositorio;

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

		return new RespuestaAlRetirarVehiculo(historialParqueo.getVehiculo().getTipoVehiculo(),
				historialParqueo.getVehiculo().getPlaca(), historialParqueo.getFechaIngreso(),
				historialParqueo.getFechaSalida(), historialParqueo.getPago());
	}

	@Override
	public HistorialParqueo traerElHistorialParqueo(String placa) {
		EntityHistorialParqueo parqueoEntity = repositorioParqueo.findByVehiculoPlaca(placa);
		return MaperHistorialParqueo.convertirAModelo(parqueoEntity);
	}

	@Override
	public boolean existeParqueovehiculo(String placa) {
		return this.repositorioParqueo.findByVehiculoPlaca(placa) != null;
	}

	@Override
	public boolean consultarSalidaVehiculo(String placa) {
		EntityHistorialParqueo parqueoEntity = this.repositorioParqueo.findByVehiculoPlaca(placa);
		return parqueoEntity.getFechaSalida() != null;
	}

	@Override
	public boolean existe(Vehiculo vehiculo) {
		return this.repositorioParqueo.findByVehiculoPlaca(vehiculo.getPlaca()) != null;
	}

	@Override
	public int cantidadVehiculos(String tipoVehiculo) {
		return repositorioParqueo.countByVehiculoTipovehiculo(tipoVehiculo);
	}

	@Override
	public List<HistorialParqueo> consultarVehiculosParqueados() {
		Iterable<EntityHistorialParqueo> listaParqueosEntities = this.repositorioParqueo.findAll();
		return MaperHistorialParqueo.convertirAModelo(listaParqueosEntities);
	}

}
