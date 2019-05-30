package application;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Mercury extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Mercury() {
		initUi();
	}
	
	private void initUi() {
		add(new CursorBoard());
		this.pack();
		this.setTitle("Mercury");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
	        Mercury mc = new Mercury();
	        mc.setVisible(true);
	    });
	}

}
