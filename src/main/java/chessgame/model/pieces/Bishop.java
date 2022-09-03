package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.movements.BishopDirectionStrategy;
import chessgame.model.player.Color;

public class Bishop extends Piece {

	public Bishop(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {				
		return new BishopDirectionStrategy(this).getPossibleMoves();
	}

}
