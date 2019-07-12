package com.ceiba.excepcion;

public class ExcepcionValoresObligatorios extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionValoresObligatorios(String message) {
        super(message);
    }
}
