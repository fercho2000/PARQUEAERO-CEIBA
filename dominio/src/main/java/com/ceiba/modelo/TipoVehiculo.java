package com.ceiba.modelo;

public enum TipoVehiculo {
	MOTO("moto"), AUTO("auto");

	private final String code;

	TipoVehiculo(String code) {
		this.code = code;
	}

	public static TipoVehiculo fromCode(String code) {
		if (code.equals("auto") || code.equals("AUTO")) {
			return AUTO;
		}

		if (code.equals("moto") || code.equals("MOTO")) {
			return MOTO;
		}

		throw new UnsupportedOperationException("The code " + code + " is not supported!");
	}
	
	public String getCode() {
        return code;
    }
}
