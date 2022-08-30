package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Cell;
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
			
			if(dest == null)
				continue;
			
			final var destPiece = dest.getPiece();
			
			if(i == currentColumn) {
				if(destPiece == null)
					moves.add(dest);
				
				continue;
			}
			
			if(destPiece != null && !destPiece.getColor().equals(color)) {
				moves.add(dest);
				continue;
			}
			
		}

		return moves;
	}

}
