package com.mitocode.model.entity;

public enum Status {

	//EMITIDO(1), ELIMINADO(2), ANULADO(3);
	ISSUED(1),REMOVED(2),CANCELED(3);

	private final int codeStatus;

	Status(int codeStatus) {
		this.codeStatus=codeStatus;
	}

	public int getCodeStatus() {
		return this.codeStatus;
	}
}
