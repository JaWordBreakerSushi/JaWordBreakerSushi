import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

import game.Game;
import game.Interface;
import game.MainWindow;


public class Main {
	
	private static MainWindow _gameInterface;
	private AudioClip sound;  
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		/*Initiate the game*/
		
		_gameInterface = new MainWindow();

		_gameInterface.showWindow();
		
		
        /*java.applet.AudioClip clip = java.applet.Applet.newAudioClip(new java.net.URL( "file:/home/amethyste/Bureau/JAVA/JaWordBreakerSushi/welcome.wav"));
        clip.play();*/
		
	    File file = new File("file:/home/amethyste/Bureau/JAVA/JaWordBreakerSushi/welcome.wav");
	    AudioClip clip;
	    try {
	        clip = JApplet.newAudioClip(file.toURL());
	        clip.play();
	    } catch (Exception e) {
	        e.getMessage();
	    }

	}
}
	


