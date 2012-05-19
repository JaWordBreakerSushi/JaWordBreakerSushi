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
	private float _masse = 0;
	private JPanel _gameArea;
	private int _timeToWait = 30;
	
	public Ball(JPanel gameArea) {
	_gameArea = gameArea;
		ImageIcon imgIcon = new ImageIcon("./src/img/bille.png");
		JLabel img = new JLabel(imgIcon);
		_width = imgIcon.getIconWidth();
		_height = imgIcon.getIconHeight();
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
			_dX = 0;
			_dY = 0;
			this.display(-100, -100);
			/*If ball (=> life)*/
			if (Game.get_listOfBall().size() > 1)
			{
				//Launch a new ball
				Game.get_listOfBall().getLast().display(Game.get_width()/2 - (Game.get_listOfBall().get(0).get_width()/2), Game.get_palet().getPositionY() - Game.get_listOfBall().get(0).get_height());
				Game.get_listOfBall().removeFirst();
				game.Interface.displayNbBalls(Game.get_listOfBall().size());
				Game.get_palet().display(Game.get_width()/2 - Game.get_palet().get_width()/2, Game.get_height() - Game.get_palet().get_height());
			}
			else
			{
				System.out.println("PERDU!");
				game.Interface.displayNbBalls(Game.get_listOfBall().size());
			}
		}

		if (this._positionX >= Game.get_palet().getPositionX() - this._width &&
				this._positionX <= Game.get_palet().getPositionX() + Game.get_palet().get_width() &&
				this._positionY >= Game.get_palet().getPositionY() - this._height &&
				this._positionY <= Game.get_palet().getPositionY() + Game.get_palet().get_height()
				)
		{
			
			//Depends on the point of the collision (middle or border)
			///palet's middle
			if (this._positionX >= Game.get_palet().getPositionX() + (Game.get_palet().get_width()*30/100) &&
					this._positionX <= Game.get_palet().getPositionX() + (Game.get_palet().get_width()*70/100))
			{
				//double slower
				double tps = _dY;
				_dY = - _dX;
				_dX = tps;
				_timeToWait += 2;
			}
			//slower
			else
			{
				double tps = _dY;
				_dY = - _dX;
				_dX = tps;
				_timeToWait ++;
			}
			
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
				game.Interface.displayScore(Game.get_score());
				
				/*90° angle*/
				double tps = _dY;
				_dY = - _dX;
				_dX = tps;
				//speeder
				if (_timeToWait > 10)
					_timeToWait --;
				
				TypeOfGift type;
				type = Game.get_listOfBrick().get(i).get_gift();
				
				//In function of brick's type
				switch(type)
				{
					case BALL : /*Launch a new ball (+)*/
								//System.out.println("BALL!!");
								Game.get_listOfBall().add(new Ball(Game.get_gameArea()));
								game.Interface.displayNbBalls(Game.get_listOfBall().size());
								Game.get_listOfBrick().get(i).hide();
								Game.set_score(Game.get_score() + 10);
								break;
					case FIXE : 
								break;
					case MOVABLE :
						
						//NOT WORKING WELL
//								Game.get_listOfBrick().get(i).display(Game.get_listOfBrick().get(i).getPositionX() + 5*(int)_dX, Game.get_listOfBrick().get(i).getPositionY() + 5*(int)_dY);
//								/*Test Collision*/
//								if (Game.get_listOfBrick().get(i).isInCollisionWith() == 1)
//								{
//									Game.get_listOfBrick().get(i).display(Game.get_listOfBrick().get(i).getPositionX() - 10*(int)_dX, Game.get_listOfBrick().get(i).getPositionY() - 10*(int)_dY);
//								}		
								break;
					case BONUS : Game.set_score(Game.get_score() + 50);
								Game.get_listOfBrick().get(i).hide();
								Game.set_score(Game.get_score() + 10);
								break;
					case LETTER :
								/*Display letter*/
								game.Interface.displayLetter(Game.get_listOfBrick().get(i).get_letter());
								Game.get_listOfBrick().get(i).hide();
								Game.set_score(Game.get_score() + 10);
								break;
					case MAGIC :try {
						Game.get_listOfBrick().get(i).applicationOfGift();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
								Game.get_listOfBrick().get(i).hide();
								break;
								
					default : Game.get_listOfBrick().get(i).hide();
								break;
						
						/*
	BALL		("./src/img/bille.png"),
	LETTER		("./src/img/maki.png"),
	BONUS		("./src/img/fortune_cookies.png"),
	MAGIC		("./src/img/sushi.png"),
	TEMPORAL	("./src/img/onigiri.png"),
	FIXE		("./src/img/miso_fixe.png"),
	MOVABLE		("./src/img/miso_movable.png"),
	PALET		("./src/img/palet.png");
						 * */
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

	public int get_timeToWait() {
		return _timeToWait;
	}

	public void set_timeToWait(int timeToWait) {
		_timeToWait = timeToWait;
	}
}
