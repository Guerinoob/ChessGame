package chessgame.model.direction;

public enum EDirection {
	UP_LEFT(-1, -1),
	UP(-1, 0),
	UP_RIGHT(-1, 1),
	LEFT(0, -1),
	RIGHT(0, 1),
	BOTTOM_LEFT(1, -1),
	BOTTOM(1, 0),
	BOTTOM_RIGHT(1, 1);
	
	private int rowOffset;
	
	private int columnOffset;
			
	private EDirection(int rowOffset, int columnOffset) {
		this.rowOffset = rowOffset;
		this.columnOffset = columnOffset;
	}
	
	public int getRowOffset() {
		return rowOffset;
	}
	
	public int getColumnOffset() {
		return columnOffset;
	}
}