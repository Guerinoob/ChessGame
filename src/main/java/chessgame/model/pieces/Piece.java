package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;

public abstract class Piece {
	private PieceType type;
	
	private Cell cell;
	
	public List<Cell> getPossibleMoves() {
		return type.getMoveStrategy().execute(cell.getBoard());
	}
}
