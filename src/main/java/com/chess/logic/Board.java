package com.chess.logic;

import com.chess.logic.piece.Piece;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class Board {

	ChessField[][] boardGrid = new ChessField[8][8];

	List<Piece> activePieces = new ArrayList<>();

	boolean firstRow = false;
	boolean secondRow = false;
	boolean thirdRow = false;
	boolean fourthRow = false;
	boolean fifthRow = false;
	boolean sixthRow = false;
	boolean seventhRow = false;
	boolean eightRow = false;

	boolean firstColumn = false;
	boolean secondColumn = false;
	boolean thirdColumn = false;
	boolean fourthColumn = false;
	boolean fifthColumn = false;
	boolean sixthColumn = false;
	boolean seventhColumn = false;
	boolean eightColumn = false;

	public ChessField getChessfield(Position position) {
		return boardGrid[position.convertPositionToColumn()][position.convertPositionToRow()];
	}

	public ChessField[][] createBoardGrid() {

		initBoardGrid();

		for (Piece activePiece : activePieces) {

	//		boardGrid[activePiece.getPosition().convertPositionToColumn()][activePiece.getPosition().convertPositionToRow()] = setChessField();

		}

		return boardGrid;
	}

	private void initBoardGrid() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boardGrid[i][j] = initChessfield(i, j);
			}
		}
	}

	private ChessField initChessfield(int column, int row) {
		int alpha = 65 + column;
		String rowInPosition = Integer.toString(row + 1);
		String columnInPosition = String.valueOf((char)alpha);
		String positionNotation = columnInPosition + rowInPosition;
		ChessField emptyChessField = new ChessField(Position.valueOf(positionNotation), null);
		return emptyChessField;
	}

	@Test
	public void tryout(){
		createBoardGrid();
		System.out.println(boardGrid[1][4].getPosition() + " is occupied by " + boardGrid[1][4].getPiece());

	}

}
