package com.ceiba.builderparqueo;

import com.ceiba.entity.EntityHistorialParqueo;
import com.ceiba.modelo.HistorialParqueo;

public class MaperHistorialParqueo {

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
