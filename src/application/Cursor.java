package application;

import java.awt.event.KeyEvent;

public class Cursor extends Sprite{
	private int dx;
	private int dy;
	private int delta = 4;
	private final int WINDOW_WIDTH;
	private final int WINDOW_HEIGHT;
	
	public Cursor(int width,int height) {
		super(width/2,height-150);
		setImage("src/images/cursor_20px.png");
		WINDOW_WIDTH = width;
		WINDOW_HEIGHT = height;
		dy=1;
	}

	public void move() {
		if(x>delta&& dx<0) x += dx;
		else if(x<WINDOW_WIDTH-width/2-delta && dx>0) x+=dx;
		if(y>delta && dy<0) y += dy;
		else if(y<WINDOW_HEIGHT-height+delta && dy>0) y+=dy;
	}
	
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -delta;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = delta;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -delta;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = delta;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }
}
