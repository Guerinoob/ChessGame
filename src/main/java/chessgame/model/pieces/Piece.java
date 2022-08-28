package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.player.Color;

public class Piece {
	private PieceType type;
	
	private Cell cell;
	
	private final Color color;
		
	public Piece(PieceType type, Color color, Cell cell) {
		this.type = type;
		this.cell = cell;
		this.color = color;
		cell.setPiece(this);
	}
	
	public List<Cell> getPossibleMoves() {
		return type.getMoveStrategy().execute(cell.getBoard());
	}
	
	public PieceType getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets a piece and returns the previous piece on the cell
	 * @param piece The new piece
	 * @return The previous piece
	 */
	public Piece setCell(Cell cell) {
		this.cell = cell;
		return cell.setPiece(this);
	}
	
	public void promote(PieceType newType) {
		if(!type.equals(PieceType.PAWN))
			return;
		
		type = newType;
	}
}
