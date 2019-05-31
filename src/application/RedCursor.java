package application;

import java.net.URL;

public class RedCursor extends Sprite {
	
	private int delta=10;

	public RedCursor(int x, int y) {
		super(x, y);
		URL url = this.getClass().getResource("/images/redcursor_40px.png");
		setImage(url);
	}
	
	public void move() {
		y+=delta;
		if(y>WINDOW_HEIGHT) this.visible=false;
	}

}
