package chessgame.model.movements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.pieces.Piece;

public abstract class DirectionalStrategy implements IDirectionalStrategy {
	private List<Direction> directions;
	
	private Piece piece;
	
	public DirectionalStrategy(Piece piece) {
		directions = new ArrayList<>();
		this.piece = piece;
	}
	
	public void addDirection(Direction direction) {
		directions.add(direction);
	}
	
	public void addDirections(Collection<Direction> directions) {
		directions.forEach(this::addDirection);
	}
	
	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = piece.getCell().getRow();
		final var currentColumn = piece.getCell().getColumn();
		final var board = piece.getCell().getBoard();
				
		final var moves = new ArrayList<Cell>();
				
		for(int i = 1; i < Board.LENGTH; i++) {
			for(int j = 0; j < directions.size(); j++) {
				final var direction = directions.get(j);
				
				if(direction.getStop())
					continue;
				
				final var dest = board.getCell(currentRow + (i * direction.getRowOffset()), currentColumn + (i * direction.getColumnOffset()));
				
				if(checkCell(dest) == false) {
					direction.setStop(true);
					continue;
				}
				
				moves.add(dest);
				
				if(dest.isOccupied()) {
					direction.setStop(true);
					continue;
				}
			}
			
		}
				
		return moves;
	}
	
	private boolean checkCell(Cell cell) {		
		return cell != null && (!cell.isOccupied() || !cell.getPiece().getColor().equals(piece.getColor()));
	}
}
