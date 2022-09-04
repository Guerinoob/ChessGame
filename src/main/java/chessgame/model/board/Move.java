package chessgame.model.board;

import chessgame.model.pieces.Pawn;
import chessgame.model.pieces.Piece;

public class Move {
	
	private Cell initialCell;
	private Cell destinationCell;
	
	private Piece pieceMoved;
	private Piece pieceTaken;
	
	private boolean isEnPassant;
	
	public Move(Cell initialCell, Cell destinationCell) {
		this.initialCell = initialCell;
		this.destinationCell = destinationCell;
	}
	
	public void execute() {
		pieceMoved = initialCell.getPiece();
		
		if(checkIsEnPassant(destinationCell)) {
			final var enemyCell = initialCell.getBoard().getCell(initialCell.getRow(), destinationCell.getColumn());
			pieceTaken = enemyCell.setPiece(null);
			destinationCell.setPiece(pieceMoved);
		}
		else {
			pieceTaken = destinationCell.setPiece(pieceMoved);
		}
		
		if(pieceTaken != null)
			pieceTaken.setCell(null);
				
		initialCell.setPiece(null);
	}
	
	public void undo() {
		initialCell.setPiece(pieceMoved);
		destinationCell.setPiece(pieceTaken);
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
	
	public boolean getIsEnPassant() {
		return isEnPassant;
	}
	
	private boolean checkIsEnPassant(Cell destinationCell) {
		if(pieceMoved instanceof Pawn == false) 
			return false;
		
		final var pawn = (Pawn) pieceMoved;
		
		return pawn.canCaptureEnPassant(destinationCell);
	}
}
