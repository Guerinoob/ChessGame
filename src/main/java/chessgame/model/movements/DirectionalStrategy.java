package chessgame.model.movements;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.pieces.Piece;

public abstract class DirectionalStrategy implements IDirectionalStrategy {
	
	private Piece piece;
	
	public DirectionalStrategy(Piece piece) {
		this.piece = piece;
	}
		
	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = piece.getCell().getRow();
		final var currentColumn = piece.getCell().getColumn();
		final var board = piece.getCell().getBoard();
				
		final var moves = new ArrayList<Cell>();
		
		for(var direction : getDirections()) {
			for(int i = 1; i < Board.LENGTH; i++) {
				final var dest = board.getCell(currentRow + (i * direction.getRowOffset()), currentColumn + (i * direction.getColumnOffset()));
				
				if(checkCell(dest) == false) 
					break;
				
				moves.add(dest);
				
				if(dest.isOccupied()) 
					break;
			}
		}
				
		return moves;
	}
	
	private boolean checkCell(Cell cell) {		
		return cell != null && (!cell.isOccupied() || !cell.getPiece().getColor().equals(piece.getColor()));
	}
}
