package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.board.Move;
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
		return type.getMoveStrategy().execute(this, cell.getBoard());
	}
	
	public PieceType getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Cell getCell() {
		return cell;
	}
	
	/**
	 * Sets a piece and returns the previous piece on the cell
	 * @param piece The new piece
	 * @return The previous piece
	 */
	public Piece setCell(Cell cell) {
		final var oldCell = this.cell;
		this.cell = cell;
		oldCell.setPiece(null);
		return cell.setPiece(this);
	}
	
	public void promote(PieceType newType) {
		if(!type.equals(PieceType.PAWN))
			return;
		
		type = newType;
	}
	
	public Move move(Cell destination) {
		final var possibleMoves = getPossibleMoves();
		
		if(!possibleMoves.contains(cell))
			return null;
		
		final var move = new Move(cell, destination);
		move.execute();
		return move;
	}
}
