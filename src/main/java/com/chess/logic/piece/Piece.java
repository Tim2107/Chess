package com.chess.logic.piece;

import com.chess.logic.Alliance;
import com.chess.logic.ChessPattern;
import com.chess.logic.Position;

public class Piece {

	String name;
	Position position;
	Alliance alliance;
	ChessPattern chessPattern;


	public Piece(){}

	public Piece(String name, Position position, ChessPattern chessPattern) {	this.name = name;
		setAllianceFromName(name);
		this.position = position;
		this.chessPattern = chessPattern;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Alliance getAlliance() {
		return alliance;
	}

	public void setAllianceFromName(String pieceName) {
		String parsedName[] = pieceName.split("");
		if (parsedName[0] == "white") {
			this.alliance = Alliance.WHITE;
		} else if
			(parsedName[0] == "black"){
			this.alliance = Alliance.BLACK;
		} else{
			throw new IllegalArgumentException("Alliance must be either black or white ;) ");
		}

		this.alliance = alliance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
