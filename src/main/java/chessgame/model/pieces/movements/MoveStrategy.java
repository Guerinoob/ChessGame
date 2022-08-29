package chessgame.model.pieces.movements;

import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.pieces.Piece;

public interface MoveStrategy {
	public List<Cell> execute(Piece piece, Board board);
}
