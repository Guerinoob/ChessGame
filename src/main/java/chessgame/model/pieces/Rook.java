package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;
import chessgame.model.direction.EDirection;
import chessgame.model.movements.DirectionalStrategy;
import chessgame.model.player.Color;

public class Rook extends Piece {

	public Rook(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		return new DirectionalStrategy(this) {
			
			@Override
			public List<Cell> getPossibleMoves() {
				this.addDirections(List.of(
					new Direction(EDirection.UP),
					new Direction(EDirection.BOTTOM),
					new Direction(EDirection.LEFT),
					new Direction(EDirection.RIGHT)
				));
				return super.getPossibleMoves();
			}
		}.getPossibleMoves();
	}

}
