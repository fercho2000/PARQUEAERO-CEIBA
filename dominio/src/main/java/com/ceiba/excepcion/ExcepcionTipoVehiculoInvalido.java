package com.ceiba.excepcion;

public class ExcepcionTipoVehiculoInvalido extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public ExcepcionTipoVehiculoInvalido(String mensaje) {
        super(mensaje);
    }
}
