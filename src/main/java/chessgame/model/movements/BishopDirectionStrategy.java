package chessgame.model.movements;

import java.util.List;

import chessgame.model.direction.Direction;
import chessgame.model.direction.EDirection;
import chessgame.model.pieces.Piece;

public class BishopDirectionStrategy extends DirectionalStrategy {

	public BishopDirectionStrategy(Piece piece) {
		super(piece);
		this.addDirections(List.of(
			new Direction(EDirection.UP_LEFT),
			new Direction(EDirection.UP_RIGHT),
			new Direction(EDirection.BOTTOM_LEFT),
			new Direction(EDirection.BOTTOM_RIGHT)
		));
	}

}
