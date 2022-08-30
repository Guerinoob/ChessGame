package chessgame.model.pieces.movements;

import java.util.ArrayList;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.pieces.Piece;

public class KingMoveStrategy implements MoveStrategy {

	@Override
	public List<Cell> execute(Piece piece, Board board) {
		final var currentCell = piece.getCell();
		final var currentRow = currentCell.getRow();
		final var currentColumn = currentCell.getColumn();
		
		final var moves = new ArrayList<Cell>();
		
		for(int i = currentRow - 1; i <= currentRow + 1; i++) {
			for(int j = currentColumn - 1; j <= currentColumn + 1; j++) {
				final var cell = board.getCell(i, j);
				
				if(cell == null) 
					continue;
				
				final var cellPiece = cell.getPiece();
				
				if(cellPiece != null && cellPiece.getColor().equals(piece.getColor()))
					continue;
				
				//TODO : check for check
				
				moves.add(cell);
			}
		}
		return moves;
	}

}
