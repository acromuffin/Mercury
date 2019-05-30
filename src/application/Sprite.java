package application;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image img;
	protected boolean visible;
	
	public Sprite(int x,int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	public void setImage(String url) {
		ImageIcon ii = new ImageIcon(url);
		img = ii.getImage();
		setImageSize();
	}
	
	protected void setImageSize() {
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Image getImage() {
		return this.img;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean val) {
		this.visible = val;
	}
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Rectangle getBox() {
		return new Rectangle(x,y,width,height);
	}

	
}
