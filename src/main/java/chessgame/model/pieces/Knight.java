package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.player.Color;

public class Knight extends Piece {

	public Knight(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = cell.getRow();
		final var currentColumn = cell.getColumn();
		final var board = cell.getBoard();
		
		final var moves = new ArrayList<Cell>();
		
		for(int i = currentRow - 2; i <= currentRow + 2; i++) {
			for(int j = currentColumn - 2; j <= currentColumn + 2; j++) {
				final var rowDiff = Math.abs(currentRow - i);
				final var columnDiff = Math.abs(currentColumn - j);
				
				if(rowDiff + columnDiff != 3)
					continue;
				
				final var dest = board.getCell(i, j);
				
				if(dest == null)
					continue;
				
				final var piece = dest.getPiece();
				
				if(piece != null && piece.getColor().equals(color))
					continue;
				
				moves.add(dest);
			}
		}
				
		return moves;
	}

}
