package br.com.southsystem.entities.enums;

public enum TipoPessoa {
	
	PF(1),
	PJ(2);
	
	private int code;
	
	private TipoPessoa(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoPessoa valueOf(int code) {
		for (TipoPessoa value : TipoPessoa.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código TipoPessoa inválido");
	}
}
