package chessgame.model.service;

import chessgame.model.game.Game;
import chessgame.model.pieces.King;
import chessgame.model.pieces.Piece;
import chessgame.model.player.Color;
import chessgame.model.player.Player;

public class CheckmateService implements Service {
	
	public Player checked(Game game) {
		if(isChecked(Color.WHITE, game))
			return game.getWhitePlayer();
		
		if(isChecked(Color.BLACK, game))
			return game.getBlackPlayer();
		
		return null;
	}
	
	public Player checkedMate(Game game) {
		if(isCheckedMate(Color.WHITE, game))
			return game.getWhitePlayer();
		
		if(isCheckedMate(Color.BLACK, game))
			return game.getBlackPlayer();
		
		return null;
	}
	
	private boolean isChecked(Color color, Game game) {
		final var player = color.equals(Color.WHITE) ? game.getWhitePlayer() : game.getBlackPlayer();

		return getKing(player).isThreathened();
	}
	
	private boolean isCheckedMate(Color color, Game game) {
		if(!isChecked(color, game))
			return false;
		
		final var player = color.equals(Color.WHITE) ? game.getWhitePlayer() : game.getBlackPlayer();
				
		for(final var piece : player.getAlivePieces()) {
			for(final var cell : piece.getPossibleMoves()) {
				if(!piece.moveImpliesCheck(cell))
					return false;
			}
		}
		
		return true;
	}
	
	private Piece getKing(Player player) {
		return player.getAlivePieces().stream().filter(piece -> piece instanceof King).findFirst().orElse(null);
	}
}
