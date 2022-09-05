package chessgame.model.board;

import chessgame.model.pieces.Pawn;
import chessgame.model.pieces.Piece;

public class Move {
	
	private Cell initialCell;
	private Cell destinationCell;
	private Cell enPassantCell;
	
	private Piece pieceMoved;
	private Piece pieceTaken;
	
	private boolean isEnPassant;
	
	public Move(Cell initialCell, Cell destinationCell) {
		this.initialCell = initialCell;
		this.destinationCell = destinationCell;
		isEnPassant = false;
	}
	
	public void execute() {
		pieceMoved = initialCell.getPiece();
		
		if(checkIsEnPassant(destinationCell)) {
			isEnPassant = true;
			enPassantCell = initialCell.getBoard().getCell(initialCell.getRow(), destinationCell.getColumn());
			pieceTaken = enPassantCell.setPiece(null);
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
		
		if(isEnPassant) {
			destinationCell.setPiece(null);
			enPassantCell.setPiece(pieceTaken);
		}
		else {
			destinationCell.setPiece(pieceTaken);
		}
	}
	
	public Cell getInitialCell() {
		return initialCell;
	}

	public Cell getDestinationCell() {
		return destinationCell;
	}
	
	public Cell getEnPassantCell() {
		return enPassantCell;
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
