package com.ceiba.excepcion;

public class ExcepcionExistencia extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionExistencia(String mensaje) {
        super(mensaje);
    }
}
