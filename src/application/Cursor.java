package application;

import java.awt.event.KeyEvent;
import java.net.URL;

public class Cursor extends Sprite{
	private int dup;
	private int ddown;
	private int dleft;
	private int dright;
	private int delta = 4;
	private final int WINDOW_WIDTH;
	private final int WINDOW_HEIGHT;
	
	public Cursor(int width,int height) {
		super(width/2,height-150);
		URL url = this.getClass().getResource("/images/cursor_20px.png");
		setImage(url);
		WINDOW_WIDTH = width;
		WINDOW_HEIGHT = height;
		ddown=1;
	}

	public void move() {
		if(dleft-dright!=0) {
			if(x>delta&& dleft>0) x -= dleft;
			else if(x<WINDOW_WIDTH-width/2-delta && dright>0) x += dright;
		}
		if(dup-ddown!=0) {
			if(y>delta && dup>0) y -= dup;
			else if(y<WINDOW_HEIGHT-height+delta && ddown>0) y+=ddown;
		}
	}
	
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dleft = delta;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dright = delta;
        }

        if (key == KeyEvent.VK_UP) {
            dup = delta;
        }

        if (key == KeyEvent.VK_DOWN) {
            ddown = delta;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dleft = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dright = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dup = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            ddown = 1;
        }
    }
}
