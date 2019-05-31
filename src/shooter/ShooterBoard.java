package shooter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ShooterBoard extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 600;
	private final int DELAY = 10;
	
	private CursorShooter cursor;
	private RedBoss boss;
	private Timer timer;
	private boolean inGame;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cursor.move();
		
		this.repaint();
	}
	
	public ShooterBoard() {
		this.addKeyListener(new KLi());
		this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		initGame();
		startGame();
	}
	
	private void initGame() {
		cursor = null;
		boss = null;
		timer = null;
		inGame = false;
	}
	
	private void startGame() {
		cursor = new CursorShooter();
		boss = new RedBoss();
		timer = new Timer(DELAY,this);
		inGame = true;
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) drawInGame(g);
		else drawOutGame(g);
	}
	
	private void drawInGame(Graphics g) {
		g.drawImage(cursor.getImage(), cursor.getX(), cursor.getY(), this);
		g.drawImage(boss.getImage(), boss.getX(), boss.getY(), this);
	}

	private void drawOutGame(Graphics g) {
		
	}
	
	
	private class KLi implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
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
