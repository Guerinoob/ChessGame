package chessgame.model.pieces;

import java.util.List;
import java.util.Set;

import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.movements.DirectionalStrategy;
import chessgame.model.movements.IDirectionalStrategy;
import chessgame.model.player.Color;

public class Queen extends Piece {
	
	private IDirectionalStrategy directionalStrategy;

	public Queen(Color color, Cell cell) {
		super(color, cell);
		directionalStrategy = new DirectionalStrategy(this) {
			
			@Override
			public Set<Direction> getDirections() {
				return Set.of(
					Direction.UP_LEFT,
					Direction.UP,
					Direction.UP_RIGHT,
					Direction.LEFT,
					Direction.RIGHT,
					Direction.BOTTOM_LEFT,
					Direction.BOTTOM,
					Direction.BOTTOM_RIGHT
				);
			}
		};
	}

	@Override
	public List<Cell> getPossibleMoves() {				
		return directionalStrategy.getPossibleMoves();
	}

}
