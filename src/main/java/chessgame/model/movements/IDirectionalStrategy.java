package chessgame.model.movements;

import java.util.List;
import java.util.Set;

import chessgame.model.board.Cell;
import chessgame.model.direction.Direction;

public interface IDirectionalStrategy {
	List<Cell> getPossibleMoves();
	Set<Direction> getDirections();
}
