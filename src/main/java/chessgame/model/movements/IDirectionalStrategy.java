package chessgame.model.movements;

import java.util.List;

import chessgame.model.board.Cell;

public interface IDirectionalStrategy {
	List<Cell> getPossibleMoves();
}
