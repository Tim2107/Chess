package com.chess.gui;

import com.chess.logic.Board;
import com.chess.logic.Position;
import com.sun.xml.internal.ws.api.message.MessageWritable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Table {

	private final JFrame gameFrame;

	private final BoardPanel boardPanel;
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);

	private final static Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);

	private static String defaultPieceImagesPath = "art/";

	//private final Board board;

	private final Color lightTileColor = Color.decode("#FFFACD");
	private final Color darkTileColor = Color.decode("#593E1A");

	public Table() throws IOException {
		this.gameFrame = new JFrame("JTimChess");
		this.gameFrame.setLayout(new BorderLayout());
		final JMenuBar tableMenuBar = crateTableMenuBar();
		this.gameFrame.setJMenuBar(tableMenuBar);
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		//this.board = Board.createBoard();
		this.boardPanel = new BoardPanel();
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		this.gameFrame.setVisible(true);
	}

	private JMenuBar crateTableMenuBar() {
		final JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFileMenu());
		return tableMenuBar;
	}

	private JMenu createFileMenu() {

		final JMenu fileMenu = new JMenu("File");
		final JMenuItem openPgn = new JMenuItem("Load PGN File");
		final JMenuItem exitMenuItem = new JMenuItem("Exit");

		openPgn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("open up that pgn file....");
			}
		});
		fileMenu.add(openPgn);

		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);

		return fileMenu;
	}

	private class BoardPanel extends JPanel {

		final List<TilePanel> boardTiles;

		BoardPanel() throws IOException {
			super(new GridLayout(8, 8));
			this.boardTiles = new ArrayList<>();

			for (Position boardTile : Position.values()) {
				final TilePanel tilePanel = new TilePanel(this, boardTile);
				this.boardTiles.add(tilePanel);
				add(tilePanel);
			}
			setPreferredSize(BOARD_PANEL_DIMENSION);
			validate();
		}
	}

	private class TilePanel extends JPanel {

		private final Position tileId;

		TilePanel(final BoardPanel boardPanel, final Position tileId) throws IOException {
			super(new GridBagLayout());
			this.tileId = tileId;
			setPreferredSize(TILE_PANEL_DIMENSION);

			assignTileColor();
			//assignTilePieceIcon(board);
			validate();
		}

		private void assignTilePieceIcon(final Board board) throws IOException {
			this.removeAll();
			if (board.getChessfield(this.tileId) != null) {
				final BufferedImage image = ImageIO.read(
					new File(defaultPieceImagesPath + "_" + board.getChessfield(this.tileId).getPiece().getAlliance().toString() + board.getChessfield(this.tileId).getPiece().getName() + ".gif"));
				add(new JLabel(new ImageIcon(image)));
			}
		}

		private void assignTileColor() {
			if (tileId.convertPositionToRow() % 2 == 0) {
				setBackground(this.tileId.convertPositionToColumn() % 2 == 0 ? lightTileColor : darkTileColor);
			} else {
				setBackground(this.tileId.convertPositionToColumn() % 2 == 1 ? lightTileColor : darkTileColor);

			}
		}

	}

}
