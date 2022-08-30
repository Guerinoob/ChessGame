package chessgame.controller;

import java.net.URL;
import java.util.ResourceBundle;

import chessgame.display.CellPane;
import chessgame.model.board.Board;
import chessgame.model.game.Game;
import chessgame.model.observer.GameObserver;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameController implements Initializable, GameObserver {
	@FXML
	private StackPane boardContainer;
	
	private GridPane boardGrid;
	
	private ObjectProperty<CellPane> selectedPane;
	
	private Game game;
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		boardGrid = new GridPane();
		
		game = new Game(600);
		game.registerObserver(this);

		for(int i = 0; i < Board.LENGTH; i++) {
			for(int j = 0; j < Board.LENGTH; j++) {
				final var pane = new CellPane(game.getBoard().getCell(i, j));
								
				if((i + j) % 2 == 0)
					pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				else
					pane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
				
				final var piece = game.getBoard().getCell(i, j).getPiece();
								
				pane.setPiece(piece);
				
				pane.setPrefSize(75, 75);
				
				setListeners(pane);
				
				boardGrid.add(pane, j, i);
			}
		}
		
		boardGrid.setPrefSize(600, 600);
		boardGrid.setAlignment(Pos.CENTER);
				
		boardContainer.getChildren().add(boardGrid);
		
		selectedPane = new SimpleObjectProperty<>();
		selectedPane.addListener((obs, oldV, newV) -> {
			if(oldV != null) {
				oldV.getStyleClass().remove("selected");
			}
			
			if(newV != null) {
				newV.getStyleClass().add("selected");
			}
		});
	}
	
	public void setListeners(CellPane pane) {
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> {
			//Left click
			if(MouseButton.PRIMARY.equals(evt.getButton())) {
				if(selectedPane.get() == null) {
					if(pane.getCell().getPiece() != null) {
						selectedPane.set(pane);
					}
				}
				else {
					final var piece = selectedPane.get().getCell().getPiece();
					final var moved = game.makeMove(piece, pane.getCell());
					
					if(moved) {
						selectedPane.set(null);
					}
				}
			}
		});
	}

	@Override
	public void update(Game game) {
		boardGrid.getChildren().forEach(node -> {
			final var cellPane = (CellPane) node;
			cellPane.setPiece(cellPane.getCell().getPiece());
		});
	}
}
