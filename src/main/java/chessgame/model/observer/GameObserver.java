package chessgame.model.observer;

import chessgame.model.player.Player;

public interface GameObserver {
	public void updateBoard();
	public void updateCheckmate(Player winner);
}
