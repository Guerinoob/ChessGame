package chessgame.model.board;

import chessgame.model.pieces.Piece;

public class Move {
	
	private Cell initialCell;
	private Cell destinationCell;
	
	private Piece pieceMoved;
	private Piece pieceTaken;
	
	public Move(Cell initialCell, Cell destinationCell) {
		this.initialCell = initialCell;
		this.destinationCell = destinationCell;
	}
	
	public void execute() {
		pieceMoved = initialCell.getPiece();
		pieceTaken = destinationCell.setPiece(pieceMoved);
	}
	
	public Cell getInitialCell() {
		return initialCell;
	}

	public Cell destinationCell() {
		return destinationCell;
	}
	
	public Piece getPieceMoved() {
		return pieceMoved;
	}
	
	public Piece getPieceTaken() {
		return pieceTaken;
	}
}
