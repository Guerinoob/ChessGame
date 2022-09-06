package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.movements.IDirectionalStrategy;
import chessgame.model.player.Color;

public abstract class DirectionalPiece extends Piece {
	
	protected IDirectionalStrategy directionalStrategy;

	public DirectionalPiece(Color color, Cell cell) {
		super(color, cell);
		directionalStrategy = getDirectionalStrategy();
	}
	
	public abstract IDirectionalStrategy getDirectionalStrategy();

	@Override
	public List<Cell> getPossibleMoves() {
		return directionalStrategy.getPossibleMoves();
	}

}
