package com.ceiba.excepcion;

public class ExcepcionRestriccionDia  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ExcepcionRestriccionDia(String message) {
        super(message);
    }
}
