package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.player.Color;

public class Bishop extends Piece {

	public Bishop(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = cell.getRow();
		final var currentColumn = cell.getColumn();
		final var board = cell.getBoard();
				
		final var moves = new ArrayList<Cell>();
		
		for(int i = 1; i < Board.LENGTH; i++) {
			final var dest = board.getCell(currentRow - i, currentColumn - i);
			
			if(checkCell(dest) == false)
				break;
			
			moves.add(dest);
			
			if(isOccupied(dest))
				break;
		}
		
		for(int i = 1; i < Board.LENGTH; i++) {
			final var dest = board.getCell(currentRow - i, currentColumn + i);
						
			if(checkCell(dest) == false)
				break;
			
			moves.add(dest);
			
			if(isOccupied(dest))
				break;
		}
		
		for(int i = 1; i < Board.LENGTH; i++) {
			final var dest = board.getCell(currentRow + i, currentColumn - i);
			
			if(checkCell(dest) == false)
				break;
			
			moves.add(dest);
			
			if(isOccupied(dest))
				break;
		}
		
		for(int i = 1; i < Board.LENGTH; i++) {
			final var dest = board.getCell(currentRow + i, currentColumn + i);
			
			if(checkCell(dest) == false)
				break;
			
			moves.add(dest);
			
			if(isOccupied(dest))
				break;
		}
		
		return moves;
	}
	
	private boolean checkCell(Cell cell) {
		if(cell == null)
			return false;
		
		final var piece = cell.getPiece();
		
		if(piece != null && piece.getColor().equals(color))
			return false;
		
		return true;
	}
	
	private boolean isOccupied(Cell cell) {
		return cell.getPiece() != null;
	}

}
