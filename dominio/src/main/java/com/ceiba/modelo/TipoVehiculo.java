package com.ceiba.modelo;

public enum TipoVehiculo {
	MOTO("moto"), AUTO("auto");

	private final String code;

	TipoVehiculo(String code) {
		this.code = code;
	}

	public static TipoVehiculo fromCode(String code) {
		if ("auto".equals(code) || "AUTO".equals(code)) {
			return AUTO;
		}

		if ("moto".equals(code) || "MOTO".equals(code)) {
			return MOTO;
		}

		throw new UnsupportedOperationException("The code " + code + " is not supported!");
	}
	
	public String getCode() {
        return code;
    }
}
