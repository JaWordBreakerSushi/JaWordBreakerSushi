package game;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bricks.Brick;
import bricks.TypeOfGift;

public class Ball extends JPanel {
	private int _positionX;
	private int _positionY;
	private double _dX = 1;
	private double _dY = 1;
	private int _size;
	private int _width;
	private int _height;
	private float _masse;
	/*to implement?*/
	private double _friction = 0.1;
	private JPanel _gameArea;
	private int _timeToWait = 30;
	
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
		
		if (this._positionY >= Game.get_height() - this._height)
		{
			//System.out.println ("FAIL");
			_dX = 0;
			_dY = 0;
			//this.setVisible(false);
			/*TEST POUR SAVOIR SI NOUVELLE BILLE (VIE?)*/
		}
		//System.out.println(Game.get_palet().get_width());
		//System.out.println("1/8 : "+(Game.get_palet().get_width()*20/100));
		//System.out.println("7/8 : "+(Game.get_palet().get_width()*80/100));
		if (this._positionX >= Game.get_palet().getPositionX() - this._width &&
				this._positionX <= Game.get_palet().getPositionX() + Game.get_palet().get_width() &&
				this._positionY >= Game.get_palet().getPositionY() - this._height &&
				this._positionY <= Game.get_palet().getPositionY() + Game.get_palet().get_height()
				)
		{
			///keep speed
			if (this._positionX >= Game.get_palet().getPositionX() + (Game.get_palet().get_width()*30/100) &&
					this._positionX <= Game.get_palet().getPositionX() + (Game.get_palet().get_width()*70/100))
			{
				System.out.println("MILIEU");
				
			}
			//speed ++
			else
			{
				_timeToWait --;
			}
			double tps = _dY;
			_dY = - _dX;
			_dX = tps;
		}
		
		/*test bricks collision*/
		for(int i = 0; i < Game.get_listOfBrick().size(); ++i)
		{
			if (this._positionX >= Game.get_listOfBrick().get(i).getPositionX() - this._width &&
					this._positionX <= Game.get_listOfBrick().get(i).getPositionX() + Game.get_listOfBrick().get(i).get_width() &&
					this._positionY >= Game.get_listOfBrick().get(i).getPositionY() - this._height &&
					this._positionY <= Game.get_listOfBrick().get(i).getPositionY() + Game.get_listOfBrick().get(i).get_height()
					)
			{
				/*90° angle*/
				double tps = _dY;
				_dY = - _dX;
				_dX = tps;
				
				_timeToWait ++;
				
				TypeOfGift type;
				type = Game.get_listOfBrick().get(i).get_gift();
				//In function of brick's type
				switch(type)
				{
					case FIXE : ;
					case MOVABLE : /*bouger en fonction du déplacement de la bille*/;
					default : Game.get_listOfBrick().get(i).hide();
						;
				}
				
			}
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
						//System.out.println(_positionY);
						move();
						try {
							Thread.sleep(_timeToWait/*A changer pr le bonus vitesse*/);
							//System.out.println(_timeToWait);
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
