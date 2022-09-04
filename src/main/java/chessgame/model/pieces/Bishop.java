package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.direction.EDirection;
import chessgame.model.movements.DirectionalStrategy;
import chessgame.model.player.Color;

public class Bishop extends Piece {

	public Bishop(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {				
		return new DirectionalStrategy(this) {
			
			@Override
			public List<Cell> getPossibleMoves() {
				this.addDirections(List.of(
					new Direction(EDirection.UP_LEFT),
					new Direction(EDirection.UP_RIGHT),
					new Direction(EDirection.BOTTOM_LEFT),
					new Direction(EDirection.BOTTOM_RIGHT)
				));
				return super.getPossibleMoves();
			}
		}.getPossibleMoves();
	}

}
