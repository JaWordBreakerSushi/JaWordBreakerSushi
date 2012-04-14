package game;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame{

	private JPanel _panel;
	/*Constructor*/
	public MainWindow() {
	}
	
	/*show principal window*/
	public void showWindow() {
		this.setTitle("JaWordBreaker");
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		
		_panel = new JPanel();
		//_panel.setBackground(Color.GREEN);
		this.setContentPane(_panel);
		
		this.setVisible(true);
	}
	
	/*Quit the game*/
	public void quit(){
		/*save*/
		
		/*close window*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*Getter and setter*/
	public JPanel get_panel() {
		return _panel;
	}

	public void set_panel(JPanel panel) {
		_panel = panel;
	}
	
}
