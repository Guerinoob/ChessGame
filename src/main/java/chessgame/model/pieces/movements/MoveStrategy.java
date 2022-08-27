package chessgame.model.pieces.movements;

import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;

public interface MoveStrategy {
	public List<Cell> execute(Board board);
}
