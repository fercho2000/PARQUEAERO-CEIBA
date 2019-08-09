package com.ceiba.repositorio.entity;

import javax.persistence.AttributeConverter;

import com.ceiba.modelo.TipoVehiculo;

public class TipoVehiculoConverter implements AttributeConverter<TipoVehiculo, String> {
	
	public String convertToDatabaseColumn( TipoVehiculo tipoVehiculo ) {
		if ( tipoVehiculo == null ) {
			return null;
		}

		return tipoVehiculo.getCode();
	}

	public TipoVehiculo convertToEntityAttribute( String code ) {
		if ( code == null ) {
			return null;
		}

		return TipoVehiculo.fromCode( code );
	}
}
