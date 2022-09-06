package chessgame.model.observer;

import chessgame.model.player.Player;

public interface GameObservee {
	public void notifyBoard();
	public void notifyCheckmate(Player winner);
}
