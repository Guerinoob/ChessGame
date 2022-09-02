package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.direction.EDirection;
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
		
		final var directions = new Direction[] {
			new Direction(EDirection.UP_LEFT),
			new Direction(EDirection.UP_RIGHT),
			new Direction(EDirection.BOTTOM_LEFT),
			new Direction(EDirection.BOTTOM_RIGHT),
		};
				
		for(int i = 1; i < Board.LENGTH; i++) {
			for(int j = 0; j < directions.length; j++) {
				if(directions[j].getStop())
					continue;
				
				final var dest = board.getCell(currentRow + (i * directions[j].getRowOffset()), currentColumn + (i * directions[j].getColumnOffset()));
				
				if(checkCell(dest) == false) {
					directions[j].setStop(true);
					continue;
				}
				
				moves.add(dest);
				
				if(dest.isOccupied()) {
					directions[j].setStop(true);
					continue;
				}
			}
			
		}
				
		return moves;
	}
	
	private boolean checkCell(Cell cell) {		
		return cell != null && !isOccupiedByAlly(cell);
	}

}
