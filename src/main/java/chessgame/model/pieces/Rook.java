package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.movements.RookDirectionalStrategy;
import chessgame.model.player.Color;

public class Rook extends Piece {

	public Rook(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		return new RookDirectionalStrategy(this).getPossibleMoves();
	}

}
