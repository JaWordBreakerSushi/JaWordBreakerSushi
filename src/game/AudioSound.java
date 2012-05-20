package game;
// Fig. 21.5: LoadAudioAndPlay.java
// Load an audio clip and play it.
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class AudioSound extends JApplet 
{
   private AudioClip sound;  
   
   public AudioSound(){
	   init();
   }

   // load the image when the applet begins executing
   public void init()
   {
	   URL base = this.getClass().getResource("/welcome.wav"); 
	   System.out.print(base);
       // load sounds and set currentSound
	   sound = getAudioClip(base, "welcome.wav");
	   //sound.play();

   } // end method init

   // stop the sound when the user switches Web pages
   public void stop()
   {
      sound.stop(); // stop AudioClip
   } // end method stop

} // end class LoadAudioAndPlay