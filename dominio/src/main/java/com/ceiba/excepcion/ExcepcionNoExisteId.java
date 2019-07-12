package com.ceiba.excepcion;

public class ExcepcionNoExisteId extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoExisteId(String message) {
        super(message);
    }
}
