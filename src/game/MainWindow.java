package game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame{

	private Interface _game;
	/*Constructor*/
	public MainWindow() {
	}
	
	/*show principal window*/
	public void showWindow() {
		_game = new Interface();
	}
	
	/*Quit the game*/
	public void quit(){
		/*save*/
		
		/*close window*/
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*Getter and setter*/
	public JPanel get_panel() {
		return _game.get_gameArea();
	}

	public void set_panel(Interface panel) {
		_game = panel;
	}
	
}
