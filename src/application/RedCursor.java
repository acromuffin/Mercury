package application;

public class RedCursor extends Sprite {
	
	private int delta=10;
	private final int WINDOW_HEIGHT = 600;

	public RedCursor(int x, int y) {
		super(x, y);
		setImage("src/images/redcursor_40px.png");
	}
	
	public void move() {
		y+=delta;
		if(y>WINDOW_HEIGHT) this.visible=false;
	}

}
