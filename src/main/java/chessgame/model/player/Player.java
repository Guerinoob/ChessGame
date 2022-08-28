package chessgame.model.player;

import java.util.List;

import chessgame.model.pieces.Piece;

public class Player {
	private Color color;
	
	private List<Piece> pieces;
	
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
}
