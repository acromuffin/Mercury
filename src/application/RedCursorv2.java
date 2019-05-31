package application;

import java.util.Random;

public class RedCursorv2 extends RedCursor {
	
	private int vx;
	private int vy = 5;

	public RedCursorv2(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		vx = rand.nextInt(6);
		if(rand.nextInt(2)==1) vx *= -1;
	}
	
	@Override
	public void move() {
		x += vx;
		y += vy;
		if(x<0 || x>WINDOW_WIDTH-width/2) vx*=-1;
		if(y>WINDOW_HEIGHT) this.visible=false;
	}

}
