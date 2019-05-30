package application;

import java.net.URL;

public class Thron extends Sprite {
	
	public Thron(int w,int h) {
		super(0-30, h-10);
		URL url = this.getClass().getResource("/images/thron_30px.png");
		setImage(url);
	}

}
