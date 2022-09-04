package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.player.Color;

public class King extends Piece {

	public King(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = cell.getRow();
		final var currentColumn = cell.getColumn();
		final var board = cell.getBoard();
		
		final var moves = new ArrayList<Cell>();
		
		for(int i = currentRow - 1; i <= currentRow + 1; i++) {
			for(int j = currentColumn - 1; j <= currentColumn + 1; j++) {
				final var cell = board.getCell(i, j);
				
				if(cell == null || isOccupiedByAlly(cell)) 
					continue;
				
				moves.add(cell);
			}
		}
		return moves;
	}

}
