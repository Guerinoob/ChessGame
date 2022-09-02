package chessgame.model.board;

import chessgame.model.pieces.Piece;

public class Cell {	
	private final int row;
	
	private final int column;
	
	private Piece piece;
	
	private final Board board;
	
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

		if(piece != null)
			piece.setCell(this);
		
		this.piece = piece;
		
		return old;
	}
	
	public boolean isOccupied() {
		return piece != null;
	}
}
