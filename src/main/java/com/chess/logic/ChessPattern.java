package com.chess.logic;

import org.junit.jupiter.api.Test;

public class ChessPattern {

	int[][] grid = new int[8][8];

	public ChessPattern() {
		this.grid = initializeGrid();
	}

	public int[][] setPawnPatternForPosition(Position position, Alliance alliance) {

		int pawn = 7;
		int column = position.convertPositionToColumn();
		int row = position.convertPositionToRow();

		grid[column][row] = pawn;

		if (alliance == Alliance.WHITE) {
			if (row != 7 && column != 0) {
				grid[column - 1][row + 1] = alliance.indicator;
			}
			if (row != 7 && column != 7) {
				grid[column + 1][row + 1] = alliance.indicator;
			}
		}

		if (alliance == Alliance.BLACK) {
			if (row != 0 && column != 0) {
				grid[column - 1][row + alliance.indicator] = alliance.indicator;
			}
			if (row != 0 && column != 7) {
				grid[column + 1][row + alliance.indicator] = alliance.indicator;
			}
		}
		return grid;
	}

	public int[][] setKingPatternForPosition(Position position, Alliance alliance) {

		int king = 9;
		int column = position.convertPositionToColumn();
		int row = position.convertPositionToRow();

		grid[column][row] = king;

		if (column != 0 && row != 0) {
			grid[column - 1][row - 1] = alliance.indicator;
		}
		if (column != 0 && row != 7) {
			grid[column - 1][row + 1] = alliance.indicator;
		}

		if (column != 7 && row != 0) {
			grid[column + 1][row - 1] = alliance.indicator;
		}
		if (column != 7 && row != 7) {
			grid[column + 1][row + 1] = alliance.indicator;
		}

		if (column != 0) {
			grid[column - 1][row] = alliance.indicator;
		}

		if (column != 7) {
			grid[column + 1][row] = alliance.indicator;
		}

		if (row != 0) {
			grid[column][row - 1] = alliance.indicator;
		}

		if (row != 7) {
			grid[column][row + 1] = alliance.indicator;
		}

		return grid;
	}

	public int[][] setKnightPatternForPosition(Position position, Alliance alliance) {

		int knight = -3;
		int column = position.convertPositionToColumn();
		int row = position.convertPositionToRow();

		grid[column][row] = knight;

		if (column - 2 > -1 && row - 1 > -1) {
			grid[column - 2][row - 1] = alliance.indicator;
		}
		if (column - 2 > -1 && row + 1 < 8) {
			grid[column - 2][row + 1] = alliance.indicator;
		}
		if (column + 2 < 8 && row - 1 > -1) {
			grid[column + 2][row - 1] = alliance.indicator;
		}
		if (column + 2 < 8 && row + 1 < 8) {
			grid[column + 2][row + 1] = alliance.indicator;
		}
		if (column - 1 > -1 && row - 2 > -1) {
			grid[column - 1][row - 2] = alliance.indicator;
		}
		if (column - 1 > -1 && row + 2 < 8) {
			grid[column - 1][row + 2] = alliance.indicator;
		}
		if (column + 1 < 8 && row - 2 > -1) {
			grid[column + 1][row - 2] = alliance.indicator;
		}
		if (column + 1 < 8 && row + 2 < 8) {
			grid[column + 1][row + 2] = alliance.indicator;
		}

		return grid;
	}

	public int[][] setQueenPatternForPosition(Position position, Alliance alliance) {

		int queen = 9;
		int row = position.convertPositionToRow();
		int column = position.convertPositionToColumn();
		setBishopPatternForPosition(position, alliance);
		setRookPatternForPosition(position, alliance);
		grid[column][row] = queen;
		return grid;
	}

	public int[][] setBishopPatternForPosition(Position position, Alliance alliance) {
		int bishop = -4;
		int column = position.convertPositionToColumn();
		int row = position.convertPositionToRow();

		grid[column][row] = bishop;

		for (int j = row + 1, i = column + 1; j < 8 && i < 8; j++, i++) {
			grid[i][j] = alliance.indicator;
		}

		for (int j = row - 1, i = column + 1; j > -1 && i < 8; j--, i++) {
			grid[i][j] = alliance.indicator;
		}

		for (int j = row - 1, i = column - 1; j > -1 && i > -1; j--, i--) {
			grid[i][j] = alliance.indicator;
		}

		for (int j = row + 1, i = column - 1; j < 8 && i > -1; j++, i--) {
			grid[i][j] = alliance.indicator;
		}
		return grid;
	}

	public int[][] setRookPatternForPosition(Position position, Alliance alliance) {

		int rook = -5;
		int row = position.convertPositionToRow();
		int column = position.convertPositionToColumn();

		grid[column][row] = rook;

		for (int i = 0; i < 8; i++) {
			if (i != row) {
				grid[column][i] = alliance.indicator;
			}
			if (i != column) {
				grid[i][row] = alliance.indicator;
			}
		}
		return grid;
	}

	private int[][] initializeGrid() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j] = 0;
			}
		}
		return grid;
	}

	@Test
	public void tryOut() {

		for (int j = 7; j > -1; j--) {
			for (int i = 0; i < 8; i++) {
				System.out.print(setPawnPatternForPosition(Position.A2, Alliance.BLACK)[i][j]);
			}
			System.out.println();
		}

	}

	@Test
	public void test (){
		System.out.println(setPawnPatternForPosition(Position.B7, Alliance.WHITE)[1][6]);

	}

}
