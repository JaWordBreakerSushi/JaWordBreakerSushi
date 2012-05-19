package bricks;

import java.util.Iterator;
import java.util.LinkedList;

import game.Ball;
import game.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel{
	private int _positionX;
	private int _positionY;
	private int _width;
	private int _height;
	private JPanel _gameArea;
	private boolean _isPositionned;
	private TypeOfGift _gift;
	private char letter;
	private int _typeOfGift;
	
	/*Constructor*/
	public Brick(JPanel gameArea, TypeOfGift gift/*String url*/) {
		super();
		
		_gift = gift;
		//System.out.println(url);
		ImageIcon imgIcon = new ImageIcon(gift.getUrl());
		JLabel img = new JLabel(imgIcon);
		_width = imgIcon.getIconWidth();
		_height = imgIcon.getIconHeight();
		//System.out.println("TAILLE" + _width + ";" + _height);
		this.add(img);
		this._isPositionned = false;
			
		_gameArea = gameArea;		
	}
	
	/*GETTERS AND SETTERS*/
	public int getPositionX() {
		return _positionX;
	}
	
	public void setPositionX(int x) {		
		_positionX = x;
	}
	
	public void display(int positionX, int positionY) {
		_positionX = positionX;
		_positionY = positionY;
		this.setBounds(_positionX, _positionY, _width, _height);
		//System.out.println(_positionX +";"+ _positionY +";"+ _width +";"+ _height);
		_gameArea.add(this);
		this.setVisible(true);
	}
	
	public void hide () {
		_width = 0;
		_height = 0;
		_positionX = -10;
		_positionY = -10;
		this.setBounds(_positionX, _positionY, _width, _height);
		//this.setVisible(false);
	}
	
	public int isInCollisionWith()
	{
		for (int i = 0; i < Game.get_listOfBrick().size(); ++i)
		{
			if (Game.get_listOfBrick().get(i) != this)
			{
				if (Math.abs(Game.get_listOfBrick().get(i).getPositionX() - this._positionX) <= Game.get_listOfBrick().get(i).get_width())
				{
					System.out.println("chevauche" + Math.abs(Game.get_listOfBrick().get(i).getPositionX() - this._positionX));
				}
			}
		}
		/*Colision*/
		return 1;
	}
	
	public void applicationOfGift() {
		System.out.println("CAS : " + _typeOfGift);
		switch(_typeOfGift)
		{
		/* ++ ball(s)*/
		case 0:
				Game.get_listOfBall().add(new Ball(Game.get_gameArea()));
				Game.get_listOfBall().getLast().display(Game.get_listOfBall().getFirst().get_positionX(), Game.get_listOfBall().getFirst().get_positionX());
				Game.get_listOfBall().getLast().startBallTimer();
				game.Interface.displayNbBalls(Game.get_listOfBall().size());
			break;
		/*random speed*/
		case 1:
			int speedModificator;
			//speedModificator = (int)(Math.random() * (10 -10) - 10) + 10;
			speedModificator = (int)(Math.random() * (5- (-5))) + (-5);
			System.out.println("CHANGMENT SPEED : " + speedModificator);
			for(int i = 0; i< Game.get_listOfBall().size(); ++i)
			{
				Game.get_listOfBall().get(i).set_timeToWait(Game.get_listOfBall().get(i).get_timeToWait() + speedModificator);
			}
			break;
		/*ball = bombe*/
		case 2:
			break;
		/*immobilisation of palet for a little moment*/
		case 3:
			break;
		/*modification palet size (bigger)*/
		case 4:
			break;
		/*modification palet size (smaller)*/
		case 5:
			break;
		/*Ball size modification?*/
		}
	}
	
	/*Getters and Setters*/

	public int getPositionY() {
		return _positionY;
	}
	public void setPositionY(int y) {
		_positionY= y;
	}
	
	public int get_width() {
		return _width;
	}

	public int get_height() {
		return _height;
	}

	public void set_width(int width) {
		_width = width;
	}

	public void set_height(int height) {
		_height = height;
	}

	public boolean is_isPositionned() {
		return _isPositionned;
	}

	public void set_isPositionned(boolean isPositionned) {
		_isPositionned = isPositionned;
	}

	public JPanel get_gameArea() {
		return _gameArea;
	}
	
	public TypeOfGift get_gift() {
		return _gift;
	}

	public void set_gift(TypeOfGift gift) {
		_gift = gift;
	}

	public void set_letter(char letter) {
		this.letter = letter;
	}

	public char get_letter() {
		return letter;
	}

	public void set_typeOfGift(int giftChosen) {
		this._typeOfGift = giftChosen;
	}
	
	public int get_typeOfGift() {
		return _typeOfGift;
	}

}

