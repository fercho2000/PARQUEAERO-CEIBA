package com.ceiba.excepcion;

public class ExepcionTipoVehiculoInvalido extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public ExepcionTipoVehiculoInvalido(String mensaje) {
        super(mensaje);
    }
}
