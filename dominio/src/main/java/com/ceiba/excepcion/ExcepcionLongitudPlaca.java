package com.ceiba.excepcion;

public class ExcepcionLongitudPlaca extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcepcionLongitudPlaca(String message) {
        super(message);
    }
	
}
