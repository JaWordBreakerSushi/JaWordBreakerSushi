import game.Game;
import game.Interface;
import game.MainWindow;

import javax.swing.JApplet;

public class Main extends JApplet{
	
	private static MainWindow _gameInterface;
	
	
	public static void main(String[] args) {
		/*Initiate the game*/
		
		_gameInterface = new MainWindow();

		_gameInterface.showWindow();
	}
}
