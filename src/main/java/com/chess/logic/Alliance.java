package com.chess.logic;

public enum Alliance {

	WHITE(1),
	BLACK(-1);

	final int indicator;

	Alliance(int indicator){
		this.indicator = indicator;
	}

}
