package chessgame.model.game;

import java.util.ArrayList;

import chessgame.model.board.Board;
import chessgame.model.pieces.Piece;
import chessgame.model.pieces.PieceType;
import chessgame.model.player.Color;
import chessgame.model.player.Player;

public class Game {
	private final Board board;
	
	private final Player whitePlayer;
	private final Player blackPlayer;
	
	public Game(int time) {
		board = new Board();
		
		final var whitePieces = new ArrayList<Piece>();
		final var blackPieces = new ArrayList<Piece>();
		
		for(int i = 0; i < Board.LENGTH; i++) {
			whitePieces.add(new Piece(PieceType.PAWN, Color.WHITE, board.getCell(6, i)));
			blackPieces.add(new Piece(PieceType.PAWN, Color.BLACK, board.getCell(1, i)));
		}
		
		whitePieces.add(new Piece(PieceType.ROOK, Color.WHITE, board.getCell(7, 0)));
		whitePieces.add(new Piece(PieceType.KNIGHT, Color.WHITE, board.getCell(7, 1)));
		whitePieces.add(new Piece(PieceType.BISHOP, Color.WHITE, board.getCell(7, 2)));
		whitePieces.add(new Piece(PieceType.QUEEN, Color.WHITE, board.getCell(7, 3)));
		whitePieces.add(new Piece(PieceType.KING, Color.WHITE, board.getCell(7, 4)));
		whitePieces.add(new Piece(PieceType.BISHOP, Color.WHITE, board.getCell(7, 5)));
		whitePieces.add(new Piece(PieceType.KNIGHT, Color.WHITE, board.getCell(7, 6)));
		whitePieces.add(new Piece(PieceType.ROOK, Color.WHITE, board.getCell(7, 7)));
		
		blackPieces.add(new Piece(PieceType.ROOK, Color.BLACK, board.getCell(0, 0)));
		blackPieces.add(new Piece(PieceType.KNIGHT, Color.BLACK, board.getCell(0, 1)));
		blackPieces.add(new Piece(PieceType.BISHOP, Color.BLACK, board.getCell(0, 2)));
		blackPieces.add(new Piece(PieceType.QUEEN, Color.BLACK, board.getCell(0, 3)));
		blackPieces.add(new Piece(PieceType.KING, Color.BLACK, board.getCell(0, 4)));
		blackPieces.add(new Piece(PieceType.BISHOP, Color.BLACK, board.getCell(0, 5)));
		blackPieces.add(new Piece(PieceType.KNIGHT, Color.BLACK, board.getCell(0, 6)));
		blackPieces.add(new Piece(PieceType.ROOK, Color.BLACK, board.getCell(0, 7)));
		
		whitePlayer = new Player(Color.WHITE, whitePieces);
		blackPlayer = new Player(Color.BLACK, blackPieces);
		
		whitePlayer.addTime(time);
		blackPlayer.addTime(time);
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
}
