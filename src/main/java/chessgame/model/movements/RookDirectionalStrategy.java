package chessgame.model.movements;

import java.util.List;

import chessgame.model.direction.Direction;
import chessgame.model.direction.EDirection;
import chessgame.model.pieces.Piece;

public class RookDirectionalStrategy extends DirectionalStrategy {

	public RookDirectionalStrategy(Piece piece) {
		super(piece);
		this.addDirections(List.of(
			new Direction(EDirection.UP),
			new Direction(EDirection.BOTTOM),
			new Direction(EDirection.LEFT),
			new Direction(EDirection.RIGHT)
		));
	}

}
