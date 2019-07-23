package com.ceiba.builderparqueo;

import com.ceiba.entity.EntityVehiculo;
import com.ceiba.modelo.Vehiculo;

public final class MaperVehiculo {

	private MaperVehiculo() {

	}

	public static EntityVehiculo convertirAEntidad(Vehiculo vehiculo) {
		EntityVehiculo vehiculoEntity = null;

		if (vehiculo != null) {
			vehiculoEntity = new EntityVehiculo();
			vehiculoEntity.setPlaca(vehiculo.getPlaca());
			vehiculoEntity.setTipovehiculo(vehiculo.getTipoVehiculo());
			vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
			vehiculoEntity.setMarca(vehiculo.getMarca());
			vehiculoEntity.setModelo(vehiculo.getModelo());

		}
		return vehiculoEntity;
	}

	public static Vehiculo convertirAModelo(EntityVehiculo vehiculoEntity) {
		Vehiculo vehiculo = null;

		if (vehiculoEntity != null) {

			vehiculo = new Vehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getTipovehiculo(),
					vehiculoEntity.getCilindraje(), vehiculoEntity.getMarca(), vehiculoEntity.getModelo());
		}

		return vehiculo;
	}

}
