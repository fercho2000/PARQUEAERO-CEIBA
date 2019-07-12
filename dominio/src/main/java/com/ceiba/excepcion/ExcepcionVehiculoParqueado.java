package com.ceiba.excepcion;

public class ExcepcionVehiculoParqueado extends RuntimeException{
	private static final long serialVersionUID = 1L;

    public ExcepcionVehiculoParqueado(String mensaje) {
        super(mensaje);
    }
}
