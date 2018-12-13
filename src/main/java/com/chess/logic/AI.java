package com.chess.logic;

import org.junit.jupiter.api.Test;

import java.util.Set;

public class AI implements Kowalski, Skipper {

	ChessPattern chessPattern;

	public Set<Move> comeUpWithOptions() {
		return null;
	}

	public ChessPattern getRookPattern(Position position, Alliance alliance) {
		ChessPattern rookpattern = new ChessPattern();
		rookpattern.setRookPatternForPosition(position, alliance);
	return rookpattern;
	}

	public ChessPattern getBishopPattern(Position position, Alliance alliance){
		ChessPattern bishopPattern = new ChessPattern();
		bishopPattern.setBishopPatternForPosition(position, alliance);
	return bishopPattern;
	}

	public ChessPattern getKnightPattern(Position position, Alliance alliance) {
		ChessPattern knightPattern = new ChessPattern();
		knightPattern.setKnightPatternForPosition(position, alliance);
		return knightPattern;
	}

	public ChessPattern getQueenPattern(Position position, Alliance alliance) {
		ChessPattern queenPattern = new ChessPattern();
		queenPattern.setQueenPatternForPosition(position, alliance);
		return queenPattern;
	}

	public ChessPattern getKingPattern(Position position, Alliance alliance) {
		ChessPattern kingPattern = new ChessPattern();
		kingPattern.setKingPatternForPosition(position, alliance);
		return kingPattern;
	}

	public ChessPattern getPawnPattern(Position position, Alliance alliance) {
		ChessPattern pawnPattern = new ChessPattern();
		pawnPattern.setPawnPatternForPosition(position, alliance);
		return pawnPattern;
	}

	public int[][]tacticalOverlay(AI pattern1, AI pattern2){
		int[][]overlaygrid = new int[8][8];
		for(int i = 0; i<8;i++){
			for(int j = 0; j<8;j++){
				overlaygrid[i][j]=pattern1.getRookPattern(Position.B5,Alliance.WHITE).grid[i][j]+ pattern2.getKingPattern(Position.D2,Alliance.BLACK).grid[i][j];
			}
		}
		return  overlaygrid;
	}
	public Move choseOption(Set<Move> options) {
		return null;
	}

	@Test
	public void tryOut() {

		for (int j = 7; j > -1; j--) {
			for (int i = 0; i < 8; i++) {
			//System.out.print(tacticalOverlay(new AI(),new AI())[i][j]);

			System.out.print(getPawnPattern(Position.D4,Alliance.WHITE).grid[i][j]);
			}
			System.out.println();
		}

	}
}
