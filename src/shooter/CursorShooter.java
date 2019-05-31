package shooter;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import application.Sprite;

public class CursorShooter extends Sprite {
	
	private int dup;
	private int ddown;
	private int dleft;
	private int dright;
	private int delta = 4;
	private List<Beam> beams;

	public CursorShooter() {
		super(WINDOW_WIDTH/2, 3*WINDOW_HEIGHT/4);
		URL url = this.getClass().getResource("/images/cursor_20px.png");
		setImage(url);
		ddown=1;
		beams = new ArrayList<>();
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
