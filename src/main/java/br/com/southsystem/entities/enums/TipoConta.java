package br.com.southsystem.entities.enums;

public enum TipoConta {
	
	C(1),
	E(2);
	
	private int code;
	
	private TipoConta(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoConta valueOf(int code) {
		for (TipoConta value : TipoConta.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código TipoPessoa inválido");
	}
	
}
