package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.board.Move;
import chessgame.model.player.Color;

public class Pawn extends Piece {
	
	private boolean hasMoved;
	private boolean canEnPassant;

	public Pawn(Color color, Cell cell) {
		super(color, cell);
		hasMoved = false;
		canEnPassant = false;
	}

	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = cell.getRow();
		final var currentColumn = cell.getColumn();
		final var board = cell.getBoard();
		
		final var moves = new ArrayList<Cell>();
		
		final var direction = Color.WHITE.equals(color) ? -1 : 1;
		final var nextRow = currentRow + (1 * direction);
		
		for(int i = currentColumn - 1; i <= currentColumn + 1; i++) {
			final var dest = board.getCell(nextRow, i);
			
			if(testCell(dest))
				moves.add(dest);
		}
		
		//Move 2 cells forward
		if(hasMoved)
			return moves;
		
		final var dest = board.getCell(nextRow + (1 * direction), currentColumn);
		
		if(testCell(dest))
			moves.add(dest);

		return moves;
	}
	
	private boolean testCell(Cell cell) {
		if(cell == null)
			return false;
		
		final var destPiece = cell.getPiece();
		final var currentColumn = this.cell.getColumn();
		
		//One or 2 cells forward
		if(cell.getColumn() == currentColumn) {
			if(destPiece == null)
				return true;
			
			return false;
		}
		
		//Capture enemy piece
		if(destPiece != null && !destPiece.getColor().equals(color)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Move move(Cell destination) {
		final var moved = super.move(destination);
		hasMoved = true;
		return moved;
	}

}
