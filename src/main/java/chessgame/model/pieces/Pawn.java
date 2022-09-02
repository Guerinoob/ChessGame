package chessgame.model.pieces;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.board.Move;
import chessgame.model.player.Color;

public class Pawn extends Piece {
	
	private boolean hasMoved;
	private boolean canEnPassant;

	public Pawn(Color color, Cell cell) {
		super(color, cell);
		hasMoved = false;
		canEnPassant = false;
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public boolean canEnPassant() {
		return canEnPassant;
	}
	
	public void setEnPassant(boolean value) {
		canEnPassant = value;
	}

	@Override
	public List<Cell> getPossibleMoves() {
		final var currentRow = cell.getRow();
		final var currentColumn = cell.getColumn();
		final var board = cell.getBoard();
		
		final var moves = new ArrayList<Cell>();
		
		final var direction = Color.WHITE.equals(color) ? -1 : 1;
		final var nextRow = currentRow + (1 * direction);
		
		for(int i = currentColumn - 1; i <= currentColumn + 1; i++) {
			final var dest = board.getCell(nextRow, i);
			
			if(testCell(dest))
				moves.add(dest);
		}
		
		//Move 2 cells forward
		if(hasMoved)
			return moves;
		
		final var dest = board.getCell(nextRow + (1 * direction), currentColumn);
		
		if(testCell(dest))
			moves.add(dest);

		return moves;
	}
	
	private boolean testCell(Cell dest) {
		if(dest == null)
			return false;
		
		final var destPiece = dest.getPiece();
		final var currentColumn = cell.getColumn();
		
		//One or 2 cells forward
		if(dest.getColumn() == currentColumn) {
			if(destPiece == null)
				return true;
			
			return false;
		}
		
		//Capture enemy piece
		if(isOccupiedByEnnemy(dest)) {
			return true;
		}
		else if(canCaptureEnPassant(dest)) {
			return true;
		}
		
		return false;
	}
	
	public boolean canCaptureEnPassant(Cell dest) {
		if(dest == null)
			return false;
		
		if(dest.getColumn() == cell.getColumn())
			return false;
		
		if(dest.getPiece() != null)
			return false;
		
		final var board = cell.getBoard();
		
		final var adjacent = board.getCell(getCell().getRow(), dest.getColumn());
		final var adjacentPiece = adjacent.getPiece();
		
		if(adjacentPiece == null || adjacentPiece instanceof Pawn == false) {
			return false;
		}
		
		final var pawn = (Pawn) adjacentPiece;
		
		if(pawn.canEnPassant)
			return true;
		
		return false;
	}
	
	@Override
	public Move move(Cell destination) {
		final var moved = super.move(destination);
		
		hasMoved = true;
		
		if(moved != null && Math.abs(destination.getRow() - moved.getInitialCell().getRow()) == 2)
			canEnPassant = true;
		
		return moved;
	}

}
