package chessgame.model.direction;

public class Direction {
	
	private EDirection direction;
	
	private boolean stop;
	
	public Direction(EDirection direction) {
		this.direction = direction;
		this.stop = false;
	}
	
	public int getRowOffset() {
		return direction.getRowOffset();
	}
	
	public int getColumnOffset() {
		return direction.getColumnOffset();
	}
	
	public boolean getStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
}

