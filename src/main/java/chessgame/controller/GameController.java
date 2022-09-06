package chessgame.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import chessgame.display.BoardGrid;
import chessgame.display.CellPane;
import chessgame.model.game.Game;
import chessgame.model.observer.GameObserver;
import chessgame.model.player.Player;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class GameController implements Initializable, GameObserver {
	@FXML
	private StackPane boardContainer;
	
	private BoardGrid boardGrid;
	
	private ObjectProperty<CellPane> selectedPane;
	
	private Game game;
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		
		game = new Game(600);
		game.registerObserver(this);
		
		boardGrid = new BoardGrid(game.getBoard());
		
		boardGrid.setPrefSize(600, 600);
		boardGrid.setAlignment(Pos.CENTER);
		boardGrid.getChildren().forEach(cellPane -> setListeners((CellPane) cellPane));
				
		boardContainer.getChildren().add(boardGrid);
		
		selectedPane = new SimpleObjectProperty<>();
		selectedPane.addListener((obs, oldV, newV) -> {
			if(oldV != null) {
				oldV.getStyleClass().remove("selected");
			}
			
			if(newV != null) {
				newV.getStyleClass().add("selected");
			}
			
			markMovesPossible();
		});
	}
	
	public void setListeners(CellPane pane) {
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, evt -> {
			//Left click
			if(MouseButton.PRIMARY.equals(evt.getButton())) {
				final var piece = pane.getCell().getPiece();
				final var selected = selectedPane.get();
				
				if(selected == null) {
					if(piece != null && piece.getColor().equals(game.getTurn().getColor())) {
						selectedPane.set(pane);
					}
					
					return;
				}
				
				final var selectedPiece = selected.getCell().getPiece();
				
				if(piece != null && selectedPiece.getColor().equals(piece.getColor())) {
					selectedPane.set(pane);
					return;
				}
				
				final var moved = game.makeMove(selectedPiece, pane.getCell());
				
				if(moved) {
					selectedPane.set(null);
				}
				
			}
		});
	}

	@Override
	public void updateBoard() {
		final var move = game.getMoves().peek();
		
		final var initial = move.getInitialCell();
		final var destination = move.getDestinationCell();
		
		boardGrid.getCellPane(initial.getRow(), initial.getColumn()).setPiece(null);
		boardGrid.getCellPane(destination.getRow(), destination.getColumn()).setPiece(move.getPieceMoved());
		
		if(move.getIsEnPassant()) {
			final var enPassantCell = move.getEnPassantCell();
			
			boardGrid.getCellPane(enPassantCell.getRow(), enPassantCell.getColumn()).setPiece(null);
		}
	}
	
	@Override
	public void updateCheckmate(Player winner) {
		
	}
	
	public void markMovesPossible() {
		final var selected = selectedPane.get();
		
		final var moves = selected != null ? selected.getCell().getPiece().getPossibleMoves() : List.of();
		
		boardGrid.getChildren().forEach(node -> {
			final var cellPane = (CellPane) node;
			final var cell = cellPane.getCell();
			
			if(moves.contains(cell)) {
				cellPane.getStyleClass().add("canMove");
			}
			else {
				cellPane.getStyleClass().remove("canMove");
			}
		});
	}
}
