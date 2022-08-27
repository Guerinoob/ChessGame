package chessgame.model.board;

public class Board {
	private Cell[][] cells;
	
	public static final int LENGTH = 8;
	
	public Board() {
		cells = new Cell[LENGTH][LENGTH];
		
		for(int i = 0; i < LENGTH; i++) {
			for(int j = 0; j < LENGTH; j++) {
				cells[i][j] = new Cell(i, j);
				
			}
		}
		
	}
}
