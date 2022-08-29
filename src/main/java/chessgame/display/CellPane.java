package chessgame.display;

import chessgame.model.board.Cell;
import chessgame.model.pieces.Piece;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CellPane extends StackPane {
	private Cell cell;
	
	private Label label;
	
	public CellPane(Cell cell) {
		super();
		this.cell = cell;
		label = new Label();
		getChildren().add(label);
	}
	
	public Cell getCell() {
		return cell;
	}
	
	public void setPiece(Piece piece) {
		if(piece == null) {
			label.setText("");
			getStyleClass().clear();
			return;
		}
		
		label.setText(""+piece.getType().name().substring(0, 2));
		getStyleClass().addAll("piece", piece.getColor().name().toLowerCase());
	}

}
