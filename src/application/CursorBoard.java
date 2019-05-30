package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CursorBoard extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 600;
	private final int DELAY = 10;

	private Cursor cursor;
	private Timer timer;
	private boolean inGame = true;
	private List<RedCursor> rlist;
	
	public CursorBoard(){
		initBoard();
	}
	
	private void initBoard() {
		this.addKeyListener(new KLi());
		this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		this.setBackground(Color.BLACK);
		cursor = new Cursor(WINDOW_WIDTH,WINDOW_HEIGHT);
		this.setFocusable(true);
		
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) drawCursor(g);
		else drawGameOver(g);
	}
	
	private void gameDraw(Graphics g) {
		if(cursor.isVisible()) drawCursor(g);
	}
	
	private void drawCursor(Graphics g) {
		g.drawImage(cursor.getImage(), cursor.getX(), cursor.getY(), this);
	}
	
	private void drawGameOver(Graphics g) {
		String str="Game Over";
		Font gmfont = new Font("Helvetica",Font.BOLD,50);
        FontMetrics fm = getFontMetrics(gmfont);
		g.setColor(Color.WHITE);
		g.setFont(gmfont);
		g.drawString(str, (WINDOW_WIDTH-fm.stringWidth(str))/2, WINDOW_HEIGHT/3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		step();
		
	}
	
	private void step() {
		cursor.move();
		this.repaint();
	}
	
	private class KLi implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			cursor.keyPressed(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			cursor.keyReleased(e);
			
		}
		
	}
}
