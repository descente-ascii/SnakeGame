package snake;

public class Position {

	int x;
	int y;
	
	public Position() {
		x=0;
		y=0;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position clone() {
		return new Position(this.x,this.y);
	}
	
	public boolean equals(Position p) {
		return this.x == p.x && this.y == p.y;
	}
	
}
