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
	private double _dX = 1;
	private double _dY = 1;
	private int _size;
	private int _width;
	private int _height;
	private float _masse;
	private double _friction = 0.1;
	private JPanel _gameArea;
	
	public Ball(JPanel gameArea) {
	_gameArea = gameArea;
		ImageIcon imgIcon = new ImageIcon("./src/img/bille.png");
		JLabel img = new JLabel(imgIcon);
		_width = imgIcon.getIconWidth();
		_height = imgIcon.getIconHeight();
		System.out.println("TAILLE" + _width + ";" + _height);
		this.add(img);
	}

	public void display(int positionX, int positionY) {
		_positionX = positionX;
		_positionY = positionY;
		this.setBounds(_positionX, _positionY, _width, _height);
		_gameArea.add(this);
		this.setVisible(true);
	}
	
	public void move() {
		_positionX += _dX;
		_positionY -= _dY;
		
		/*test walls collision*/
		
		if (_positionX <= 0 || _positionX > (game.Game.get_width() - this._width))
		{
			_dX = - _dX;
		}
		
		if (_positionY <= 0)
		{
			_dY = - _dY;
		}
		//TEMPORAIRE!!!
		if (_positionY >= game.Game.get_height())
		{
			System.out.println("OUI");//?? ne se stoppe pas ??
			_dY = 0;
			_dY = 0;
		}
		
		/*test bricks collision*/
		for(int i = 0; i < Game.get_listOfBrick().size(); ++i)
		{
//			if (this._positionX >= game.get_listOfBrick().)
//			{
//				
//			}
		}

		this.display(_positionX, _positionY);
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
						System.out.println(_positionY);
						move();
						try {
							Thread.sleep(30/*A changer pr le bonus vitesse*/);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
	//Getters and setters
	
	public int get_positionX() {
		return _positionX;
	}

	public void set_positionX(int positionX) {
		_positionX = positionX;
	}

	public int get_positionY() {
		return _positionY;
	}

	public void set_positionY(int positionY) {
		_positionY = positionY;
	}

	public int get_size() {
		return _size;
	}

	public void set_size(int size) {
		_size = size;
	}

	public int get_width() {
		return _width;
	}

	public void set_width(int width) {
		_width = width;
	}

	public int get_height() {
		return _height;
	}

	public void set_height(int height) {
		_height = height;
	}

	public float get_masse() {
		return _masse;
	}

	public void set_masse(float masse) {
		_masse = masse;
	}
}
