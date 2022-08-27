package chessgame.model.player;

import java.util.List;

import chessgame.model.pieces.Piece;
import javafx.scene.paint.Color;

public class Player {
	private Color color;
	
	private List<Piece> pieces;
	
	public Player(Color color, List<Piece> pieces) {
		this.pieces = pieces;
		this.color = color;
	}
}
