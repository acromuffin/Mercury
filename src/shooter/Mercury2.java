package shooter;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Mercury2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Mercury2() {
		initUi();
	}
	
	private void initUi() {
		add(new ShooterBoard());
		this.pack();
		this.setTitle("Mercury");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
	        Mercury2 mc = new Mercury2();
	        mc.setVisible(true);
	    });
	}

}
