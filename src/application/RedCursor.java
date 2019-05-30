package application;

public class RedCursor extends Sprite {
	
	private int delta=10;

	public RedCursor(int x, int y) {
		super(x, y);
		setImage("src/images/redcursor_40px.png");
	}
	
	public void move() {
		y+=delta;
	}

}
