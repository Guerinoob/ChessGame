package chessgame.model.pieces;

import java.util.Set;

import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.movements.DirectionalStrategy;
import chessgame.model.movements.IDirectionalStrategy;
import chessgame.model.player.Color;

public class Bishop extends DirectionalPiece {
	
	public Bishop(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public IDirectionalStrategy getDirectionalStrategy() {
		return new DirectionalStrategy(this) {
			
			@Override
			public Set<Direction> getDirections() {
				return Set.of(
					Direction.UP_LEFT,
					Direction.UP_RIGHT,
					Direction.BOTTOM_LEFT,
					Direction.BOTTOM_RIGHT
				);
			}
		};
	}

}
