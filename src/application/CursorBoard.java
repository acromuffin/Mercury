package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private List<RedCursor> reds;
	private LocalTime timestart;
	private LocalTime timeend;
	
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
		initGame();
		startGame();
		
	}
	
	private void initGame() {
		reds = new ArrayList<>();
		cursor = new Cursor(WINDOW_WIDTH,WINDOW_HEIGHT);
	}
	
	private void startGame() {
		inGame = true;
		timer.start();
		timestart = LocalTime.now();
	}
	
	private void endGame() {
		timeend = LocalTime.now();
		inGame = false;
		initGame();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) gameDraw(g);
		else drawGameOver(g);
	}
	
	private void gameDraw(Graphics g) {
		if(cursor.isVisible()) {
			g.drawImage(cursor.getImage(), cursor.getX(), cursor.getY(), this);
		}
		for(RedCursor rc : reds) {
			if(rc.isVisible()) {
				g.drawImage(rc.getImage(), rc.getX(), rc.getY(), this);
			}
		}
	}
	
	private void drawGameOver(Graphics g) {
		String str="Game Over";
		Font gmfont = new Font("Helvetica",Font.BOLD,50);
        FontMetrics fm = getFontMetrics(gmfont);
		g.setColor(Color.WHITE);
		g.setFont(gmfont);
		g.drawString(str, (WINDOW_WIDTH-fm.stringWidth(str))/2, WINDOW_HEIGHT/3);
		
		String strdu = "Score : " + getScore() ;
		Font gmfont2 = new Font("Helvetica",Font.PLAIN,30);
        FontMetrics fm2 = getFontMetrics(gmfont2);
		g.setColor(Color.WHITE);
		g.setFont(gmfont2);
		g.drawString(strdu,(WINDOW_WIDTH-fm2.stringWidth(strdu))/2, WINDOW_HEIGHT/2);
		
		String again = "Press Enter to restart";
		g.drawString(again, (WINDOW_WIDTH-fm2.stringWidth(again))/2, 2*WINDOW_HEIGHT/3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		checkCrash();
		if(inGame == false) {
			timer.stop();
		}
		addRed();
		cursor.move();
		updateRed();

		this.repaint();
	}
	
	private void addRed() {
		Random rand= new Random();
		Duration dr = Duration.between(timestart, LocalTime.now());
		int drd = (int)dr.toMillis() / 1000;
		int luck = rand.nextInt(100);
		if(luck > 99-drd*0.6-2) {
			reds.add(new RedCursor(rand.nextInt(WINDOW_WIDTH),0));
		}
		double dri = dr.toMillis();
		System.out.println( (int)(Math.pow(10, -dri*dri/300_000_000.0 + dri/3750.0)) + ":" + dr.toMillis()/1000.0 + " s");
	}
	
	private void updateRed() {
		for(int i=0;i<reds.size();i++) {
			RedCursor red = reds.get(i);
			if(red.isVisible()) {
				red.move();
			} else {
				reds.remove(i);
				i--;
			}
		}
	}
	
	private void checkCrash() {
		Rectangle rg = cursor.getBox();
		for(RedCursor red : reds) {
			Rectangle rr = red.getBox();
			if(rr.intersects(rg)) {
				endGame();
				break;
			}
		}
	}
	
	private int getScore() {
		Duration dr = Duration.between(timestart,timeend);
		double dri = dr.toMillis();
		int score = (int)(Math.pow(10, -dri*dri/300_000_000.0 + dri/3750.0));
		return score;
	}
	
	private class KLi implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			cursor.keyPressed(e);
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_ENTER && inGame == false) {
				startGame();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			cursor.keyReleased(e);
			
		}
		
	}
}
