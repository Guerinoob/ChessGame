package chessgame.model.pieces;

import java.util.List;

import chessgame.model.board.Cell;
import chessgame.model.board.Move;
import chessgame.model.game.Game;
import chessgame.model.player.Color;
import chessgame.model.service.CheckmateService;
import chessgame.model.service.ServiceManager;

public abstract class Piece {
	
	protected Cell cell;
	
	protected final Color color;
	
	protected final CheckmateService checkmateService = ServiceManager.getInstance(CheckmateService.class);
		
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
	
	public Game getGame() {
		return cell.getBoard().getGame();
	}
	
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Move move(Cell destination) {
		final var possibleMoves = getPossibleMoves();
		
		if(!possibleMoves.contains(destination) || moveImpliesCheck(destination))
			return null;
		
		final var move = new Move(cell, destination);
		move.execute();
		return move;
	}
	
	public boolean moveImpliesCheck(Cell destination) {
		final var move = new Move(cell, destination);
		move.execute();
		
		final var checkedPlayer = checkmateService.checked(cell.getBoard().getGame());
		
		move.undo();
		
		return checkedPlayer != null && checkedPlayer.getColor().equals(color);
	}
	
	public boolean isOccupiedByAlly(Cell cell) {	
		return cell.isOccupied() && cell.getPiece().getColor().equals(color);
	}
	
	public boolean isOccupiedByEnnemy(Cell cell) {		
		return cell.isOccupied() && !cell.getPiece().getColor().equals(color);
	}
	
	public boolean isThreathened() {
		final var enemy = color.equals(Color.WHITE) ? getGame().getBlackPlayer() : getGame().getWhitePlayer();
		
		for(final var piece : enemy.getAlivePieces()) {
			if(piece.getPossibleMoves().contains(cell))
				return true;
		}
		
		return false;
	}
}
