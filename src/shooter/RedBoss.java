package shooter;

import java.net.URL;

import application.Sprite;

public class RedBoss extends Sprite {

	public RedBoss() {
		super(WINDOW_WIDTH/2-50, 10);
		// TODO Auto-generated constructor stub
		URL url = getClass().getResource("/images/redcursor_40px.png");
		setImage(url);
	}

}
