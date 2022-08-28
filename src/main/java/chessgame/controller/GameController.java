package chessgame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import chessgame.model.board.Board;
import chessgame.model.game.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameController implements Initializable {
	@FXML
	private StackPane boardContainer;
	
	private GridPane boardGrid;
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		boardGrid = new GridPane();
		
		final var game = new Game();

		for(int i = 0; i < Board.LENGTH; i++) {
			for(int j = 0; j < Board.LENGTH; j++) {
				final var pane = new StackPane();
								
				if((i + j) % 2 == 0)
					pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				else
					pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
				
				final var piece = game.getBoard().getCell(i, j).getPiece();
				
				if(piece != null) {
					final var label = new Label(""+piece.getType().name().substring(0, 2));
					label.getStyleClass().addAll("piece", piece.getColor().name().toLowerCase());
					pane.getChildren().add(label);
				}
				
				pane.setPrefSize(75, 75);
				
				boardGrid.add(pane, j, i);
			}
		}
		
		boardGrid.setPrefSize(600, 600);
		boardGrid.setAlignment(Pos.CENTER);
				
		boardContainer.getChildren().add(boardGrid);
	}
}
