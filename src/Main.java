import game.Game;
import game.MainWindow;



public class Main {
	
	private static MainWindow _gameInterface;
	
	
	public static void main(String[] args) {
		//System.out.println("AAAAAAAAAAAA");
		/*Initiate the game*/
		
		_gameInterface = new MainWindow();
		
		
		_gameInterface.showWindow();
		
		//Game game = new Game();
	}
}
