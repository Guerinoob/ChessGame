package chessgame.display;

import chessgame.model.board.Board;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BoardGrid extends GridPane {
	
	private CellPane[][] children;
	
	public BoardGrid(Board board) {
		children = new CellPane[Board.LENGTH][Board.LENGTH];
		
		for(int i = 0; i < Board.LENGTH; i++) {
			for(int j = 0; j < Board.LENGTH; j++) {
				final var pane = new CellPane(board.getCell(i, j));
								
				if((i + j) % 2 == 0)
					pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				else
					pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
				
				final var piece = board.getCell(i, j).getPiece();
								
				pane.setPiece(piece);
				
				pane.setPrefSize(75, 75);
				
				add(pane, j, i);
			}
		}
	}
	
	public CellPane[][] getCells() {
		return children;
	}
	
	public void add(CellPane pane, int column, int row) {
		children[row][column] = pane;
		super.add(pane, column, row);
	}
	
	public CellPane getCellPane(int row, int column) {
		try {
			return children[row][column];
		} catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

}
