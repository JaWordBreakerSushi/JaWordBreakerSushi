import java.applet.AudioClip;
import java.io.*;

import javax.sound.sampled.*;

import game.MainWindow;

public class Main {

	private static final long serialVersionUID = 1L;
	private static MainWindow _gameInterface;
	
	public static void main(String[] args) {
		/*Initiate the game*/
		
		_gameInterface = new MainWindow();

		_gameInterface.showWindow();
		
	    try {
            File f = new File("./music.wav");
            InputStream in = new FileInputStream(f);

            InputStream bufferedIn = new BufferedInputStream(in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

			AudioFormat audioFormat = audioStream.getFormat();
			DataLine.Info dataLineInfo = new DataLine.Info(Clip.class, audioFormat);
			Clip clip = (Clip) AudioSystem.getLine(dataLineInfo);
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	    }
	    catch (Exception e) {
            e.printStackTrace();
        }
	    
	    

	}

}
	


