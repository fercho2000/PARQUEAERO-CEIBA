package com.ceiba.excepcion;

public class ExcepcionCantidadVehiculos extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcepcionCantidadVehiculos(String message) {
        super(message);
    }
}
