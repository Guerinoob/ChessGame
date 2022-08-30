package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.board.Move;
import chessgame.model.player.Color;

public abstract class Piece {
	
	protected Cell cell;
	
	protected final Color color;
		
	public Piece(Color color, Cell cell) {
		this.cell = cell;
		this.color = color;
		cell.setPiece(this);
	}
	
	abstract public List<Cell> getPossibleMoves();

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
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Move move(Cell destination) {
		final var possibleMoves = getPossibleMoves();
		
		if(!possibleMoves.contains(destination))
			return null;
		
		final var move = new Move(cell, destination);
		move.execute();
		return move;
	}
}
