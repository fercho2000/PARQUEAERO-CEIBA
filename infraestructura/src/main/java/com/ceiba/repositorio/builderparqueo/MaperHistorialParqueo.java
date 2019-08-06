
package com.ceiba.repositorio.builderparqueo;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.repositorio.entity.EntityHistorialParqueo;
import com.ceiba.modelo.HistorialParqueo;

public final class MaperHistorialParqueo {

	private MaperHistorialParqueo() {

	}

	public static HistorialParqueo convertirAModelo(EntityHistorialParqueo historialParqueoEntity) {

		HistorialParqueo parqueo = null;

		if (historialParqueoEntity != null) {
			parqueo = new HistorialParqueo(historialParqueoEntity.getFechaIngreso(),
					historialParqueoEntity.getFechaSalida(), historialParqueoEntity.getPago(),
					MaperVehiculo.convertirAModelo(historialParqueoEntity.getVehiculo()));

		}
		return parqueo;

	}
	
	public static List<HistorialParqueo> convertirAModelo(Iterable<EntityHistorialParqueo> listaParqueosEntities) {
		List<HistorialParqueo> listaParqueo = new ArrayList<>();
		for (EntityHistorialParqueo parqueoEntity : listaParqueosEntities) {
			listaParqueo.add(convertirAModelo(parqueoEntity));
		}
		return listaParqueo;
	}

	public static EntityHistorialParqueo convertirAEntidad(HistorialParqueo parqueo) {
		EntityHistorialParqueo parqueoEntity = null;

		if (parqueo != null) {
			parqueoEntity = new EntityHistorialParqueo();
			parqueoEntity.setVehiculo(MaperVehiculo.convertirAEntidad(parqueo.getVehiculo()));
			parqueoEntity.setFechaIngreso(parqueo.getFechaIngreso());
			parqueoEntity.setFechaSalida(parqueo.getFechaSalida());
			parqueoEntity.setPago(parqueo.getPago());
		}

		return parqueoEntity;
	}

	

}
