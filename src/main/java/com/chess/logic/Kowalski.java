package com.chess.logic;

import java.util.Set;

public interface Kowalski {

	public Set<Move> comeUpWithOptions();
	public ChessPattern getRookPattern(Position position, Alliance alliance);
	public ChessPattern getBishopPattern(Position position, Alliance alliance);
	public ChessPattern getKnightPattern(Position position, Alliance alliance);
	public ChessPattern getQueenPattern(Position position, Alliance alliance);
	public ChessPattern getKingPattern(Position position, Alliance alliance);
	public ChessPattern getPawnPattern(Position position, Alliance alliance);

}
