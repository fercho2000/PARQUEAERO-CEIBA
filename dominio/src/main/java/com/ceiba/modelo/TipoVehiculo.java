package com.ceiba.modelo;

public enum TipoVehiculo {
	moto("moto"), auto("auto");

	private final String code;

	TipoVehiculo(String code) {
		this.code = code;
	}

	public static TipoVehiculo fromCode(String code) {
		if (code.equals("auto") || code.equals("AUTO")) {
			return auto;
		}

		if (code.equals("moto") || code.equals("MOTO")) {
			return moto;
		}

		throw new UnsupportedOperationException("The code " + code + " is not supported!");
	}
	
	public String getCode() {
        return code;
    }
}
