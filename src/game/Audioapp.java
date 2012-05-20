package game;

import java.applet.*;
import javax.swing.*;
import java.net.*;

public class Audioapp extends JApplet
{
	private static final long serialVersionUID = 1L;

	public class Sound // Holds one audio file
	{
	  private AudioClip song; // Sound player
	  private URL songPath; // Sound path
	  
	  Sound(String filename){
	 	 try{
	 	     String str1 = "welcome.wav";  
	 	     URL url = new URL(str1);  
	 	     song = Applet.newAudioClip(url);  
	 	     song.play();
	 		 //songPath = new URL(getCodeBase(),filename); // Get the Sound URL
	 		 //song = Applet.newAudioClip(songPath); // Load the Sound
	 	 }
	 	 catch(Exception e){} // Satisfy the catch
	  }
	  
	  public void playSound(){
	 	 song.loop(); // Play 
	  }
	  
	  public void stopSound(){
	 	 song.stop(); // Stop
	  }
	  
	  public void playSoundOnce(){
	 	 song.play(); // Play only once
	  }
	}
		
	/*public void init(){
		Sound testsong = new Sound("a-team_crazy_fool_x.wav");
		//testsong.playSound();
	}*/
}


