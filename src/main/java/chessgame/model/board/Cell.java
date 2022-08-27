package chessgame.model.board;

public class Cell {
	private Color color;
	
	private int row;
	
	private int column;
	
	private Piece piece;
	
	public Cell(int row, int column) {
		if((row + column) % 2 == 0)
			color = Color.WHITE;
		else
			color = Color.BLACK;
		
		this.row = row;
		this.column = column;
		piece = null;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	/**
	 * Sets the piece and returns the previous piece on the cell
	 * @param piece The new piece
	 * @return The previous piece
	 */
	public Piece setPiece(Piece piece) {
		final var old = this.piece;
		this.piece = piece;
		
		return old;
	}
}
