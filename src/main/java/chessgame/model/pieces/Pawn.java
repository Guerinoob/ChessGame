package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.player.Color;

public class Pawn extends Piece {

	public Pawn(Color color, Cell cell) {
		super(color, cell);
	}

	@Override
	public List<Cell> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
