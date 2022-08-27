package chessgame.model.pieces;

import chessgame.model.pieces.movements.BishopMoveStrategy;
import chessgame.model.pieces.movements.KingMoveStrategy;
import chessgame.model.pieces.movements.KnightMoveStrategy;
import chessgame.model.pieces.movements.MoveStrategy;
import chessgame.model.pieces.movements.PawnMoveStrategy;
import chessgame.model.pieces.movements.QueenMoveStrategy;
import chessgame.model.pieces.movements.RookMoveStrategy;

public enum PieceType {
	KING(new KingMoveStrategy()),
	QUEEN(new QueenMoveStrategy()),
	ROOK(new RookMoveStrategy()),
	BISHOP(new BishopMoveStrategy()),
	KNIGHT(new KnightMoveStrategy()),
	PAWN(new PawnMoveStrategy());
	
	private MoveStrategy moveStrategy;
	
	private PieceType(MoveStrategy moveStrategy) {
		this.moveStrategy = moveStrategy;
	}
	
	public MoveStrategy getMoveStrategy() {
		return moveStrategy;
	}
}
