package game;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bricks.Brick;

public class Ball extends JPanel {
	private int _positionX;
	private int _positionY;
	private double _dX = 2;
	private double _dY = 2;
	private int _size;
	private float _masse;
	private double _friction = 0.1;
	
	/*stock game*/
	private Game game;
	
	public Ball(Game game) {
//		Graphics graphicInstance = game.get_gameInterface().get_panel().getGraphics();
//		_positionX = game.get_gameInterface().get_panel().getWidth()/2;
//		_positionY = game.get_gameInterface().get_panel().getHeight() - 40;
//		_size = 20;
//		graphicInstance.fillOval(_positionX, _positionY, _size, _size);
		
		
		/*get the Panel for game*/
		JPanel gameArea = game.get_gameInterface().get_panel();
		
		ImageIcon imgIcon = new ImageIcon("./src/img/bille.png");
		JLabel img = new JLabel(imgIcon);
		this.setVisible(true);
		this.add(img);
		
		//System.out.println(_positionX);

		this.setLocation(250, 480);
		
		gameArea.add(this);
		
		this.setVisible(true);		
	}
	
	public void move() {
		
		/*test walls collision*/
		
		if (_positionX <= 0 || _positionX >500)
		{
			_dX = - _dX;
		}
		
		if (_positionY <= 0)
		{
			_dY = - _dY;
		}
		
		/*test bricks collision*/
		for(int i = 0; i < game.get_listOfBrick().size(); ++i)
		{
//			if (this._positionX >= game.get_listOfBrick().)
//			{
//				
//			}
		}
		
		_positionX += _dX;
		_positionY += _dY;

		this.setLocation(_positionX, _positionY);
	}
	
	public void startBallTimer() {
		for(int i=0;i < 2;i++) 
		{
			final int id=i;
			new Thread(new Runnable() {
				public void run() 
				{
					while ( ! Thread.currentThread().isInterrupted() )
					{
						System.out.println("a");
						move();
					}
				}
			}).start();

		}
	}
}
