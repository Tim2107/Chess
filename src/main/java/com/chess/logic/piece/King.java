package com.chess.logic.piece;

import com.chess.logic.ChessPattern;
import com.chess.logic.Position;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class King extends Piece {


	ChessPattern kingPattern;



	public King(String name, Position position){
		this(name,position,new ChessPattern().setKingPatternForPosition(position,  ));

	}

	public King(String name, Position position, ChessPattern chessPattern){
	super(name, position,chessPattern);
	}

public ChessPattern initializeKingpattern(String name, Position position){
	ChessPattern kingpattern = new ChessPattern();
	setAllianceFromName(name);
	kingpattern.setKingPatternForPosition(position, this.alliance);
	return kingpattern;

}
}
