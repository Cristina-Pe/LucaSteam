package com.projecto.spring.model;

public enum ConsolasNintendo {
	
	/**
	 * Definicion del ENUM Consolas Nintendo y sus posibles valores
	 */
	WII("Wii"), GB("GB"), NES("NES"), DS("DS"), SNES("SNES"),GBA("GBA"), TRESDS("3DS"), N64("N64");
		
	private final String consolas;

	private ConsolasNintendo(String consolas) {
		this.consolas = consolas;
	}

	public String getConsolas() {
		return consolas;
	}
		
}
