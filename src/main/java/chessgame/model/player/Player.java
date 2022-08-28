package chessgame.model.player;

import java.util.List;

import chessgame.model.pieces.Piece;

public class Player {
	private final Color color;
	
	private final List<Piece> pieces;
	
	private int timeLeft;
	
	public Player(Color color, List<Piece> pieces) {
		this.pieces = pieces;
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	public void addTime(int seconds) {
		timeLeft += seconds;
	}
}
