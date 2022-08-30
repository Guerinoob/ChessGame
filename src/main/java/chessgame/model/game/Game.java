package chessgame.model.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import chessgame.model.board.Board;
import chessgame.model.board.Cell;
import chessgame.model.board.Move;
import chessgame.model.observer.GameObserver;
import chessgame.model.pieces.Bishop;
import chessgame.model.pieces.King;
import chessgame.model.pieces.Knight;
import chessgame.model.pieces.Pawn;
import chessgame.model.pieces.Piece;
import chessgame.model.pieces.Queen;
import chessgame.model.pieces.Rook;
import chessgame.model.player.Color;
import chessgame.model.player.Player;

public class Game {
	private final Board board;
	
	private final Player whitePlayer;
	private final Player blackPlayer;
	
	private Player turn;
	
	private List<Move> moves;
	
	private List<GameObserver> observers;
	
	public Game(int time) {
		board = new Board();
		
		final var whitePieces = new ArrayList<Piece>();
		final var blackPieces = new ArrayList<Piece>();
		
		for(int i = 0; i < Board.LENGTH; i++) {
			whitePieces.add(new Pawn(Color.WHITE, board.getCell(6, i)));
			blackPieces.add(new Pawn(Color.BLACK, board.getCell(1, i)));
		}
		
		whitePieces.add(new Rook(Color.WHITE, board.getCell(7, 0)));
		whitePieces.add(new Knight(Color.WHITE, board.getCell(7, 1)));
		whitePieces.add(new Bishop(Color.WHITE, board.getCell(7, 2)));
		whitePieces.add(new Queen(Color.WHITE, board.getCell(7, 3)));
		whitePieces.add(new King(Color.WHITE, board.getCell(7, 4)));
		whitePieces.add(new Bishop(Color.WHITE, board.getCell(7, 5)));
		whitePieces.add(new Knight(Color.WHITE, board.getCell(7, 6)));
		whitePieces.add(new Rook(Color.WHITE, board.getCell(7, 7)));
		
		blackPieces.add(new Rook(Color.BLACK, board.getCell(0, 0)));
		blackPieces.add(new Knight(Color.BLACK, board.getCell(0, 1)));
		blackPieces.add(new Bishop(Color.BLACK, board.getCell(0, 2)));
		blackPieces.add(new Queen(Color.BLACK, board.getCell(0, 3)));
		blackPieces.add(new King(Color.BLACK, board.getCell(0, 4)));
		blackPieces.add(new Bishop(Color.BLACK, board.getCell(0, 5)));
		blackPieces.add(new Knight(Color.BLACK, board.getCell(0, 6)));
		blackPieces.add(new Rook(Color.BLACK, board.getCell(0, 7)));
		
		whitePlayer = new Player(Color.WHITE, whitePieces);
		blackPlayer = new Player(Color.BLACK, blackPieces);
		
		whitePlayer.addTime(time);
		blackPlayer.addTime(time);
		
		turn = whitePlayer;
		moves = new LinkedList<>();
		observers = new ArrayList<>();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getWhitePlayer() {
		return whitePlayer;
	}
	
	public Player getBlackPlayer() {
		return blackPlayer;
	}
	
	public Player getTurn() {
		return turn;
	}
	
	public boolean makeMove(Piece piece, Cell destination) {
		if(!piece.getColor().equals(turn.getColor()))
			return false;
		
		final var move = piece.move(destination);
		
		if(move == null)
			return false;
		
		moves.add(move);
		switchTurn();
		
		notifyObservers();
		
		return true;
	}
	
	public void switchTurn() {
		if(turn.equals(whitePlayer))
			turn = blackPlayer;
		else
			turn = whitePlayer;
	}
	
	public boolean registerObserver(GameObserver o) {
		return observers.add(o);
	}
	
	public boolean removeObserver(GameObserver o) {
		return observers.remove(o);
	}
	
	public void notifyObservers() {
		observers.forEach(o -> o.update(this));
	}
}
