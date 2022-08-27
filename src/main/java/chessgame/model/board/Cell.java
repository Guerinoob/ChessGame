package chessgame.model.board;

import chessgame.model.pieces.Piece;

public class Cell {	
	private int row;
	
	private int column;
	
	private Piece piece;
	
	private Board board;
	
	public Cell(int row, int column, Board board) {
		this.row = row;
		this.column = column;
		this.board = board;
		piece = null;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Sets the piece and returns the previous piece on the cell
	 * @param piece The new piece
	 * @return The previous piece
	 */
	public Piece setPiece(Piece piece) {
		final var old = this.piece;
		this.piece = piece;
		
		return old;
	}
}
