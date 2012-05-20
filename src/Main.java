import game.MainWindow;

import javax.swing.JApplet;

public class Main extends JApplet{

	private static final long serialVersionUID = 1L;
	private static MainWindow _gameInterface;
	
	
	public static void main(String[] args) {
		/*Initiate the game*/
		
		_gameInterface = new MainWindow();

		_gameInterface.showWindow();
	}
}
