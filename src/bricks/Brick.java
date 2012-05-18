package bricks;

import java.util.Iterator;
import java.util.LinkedList;

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
	
	/*Constructor*/
	public Brick(JPanel gameArea, String url) {
		super();
		
		//System.out.println(url);
		ImageIcon imgIcon = new ImageIcon(url);
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
	public void setPositionX() {		
		
//		this._positionX = (int)(Math.random() * ((230 -_width) - _width)) + _width;
//		LinkedList<Brick> listOfBricks = Game.get_listOfBrick();
//		Iterator<Brick> iter = listOfBricks.iterator();
//		
//		for (int i = 0; i< listOfBricks.size(); ++i)
//		{
//			if (iter.hasNext())
//			{
//				Brick prevBrick= iter.next();
//				if( this._positionX < (prevBrick._positionX + prevBrick._width))
//				{
//					this._positionX += prevBrick._positionX + prevBrick._width - this._positionX;
//					
//					//if out of screen
////					if (this._positionX >= 230 - this._width)
////					{
////						this._positionX -= prevBrick._positionX + prevBrick._width - this._positionX; 
////						//this.setPositionY();
////					}
//				}
//			}
//		}
	}
	
	public void display(int positionX, int positionY) {
		_positionX = positionX;
		_positionY = positionY;
		this.setBounds(_positionX, _positionY, _width, _height);
		System.out.println(_positionX +";"+ _positionY +";"+ _width +";"+ _height);
		_gameArea.add(this);
		this.setVisible(true);
	}

	public int getPositionY() {
		return _positionY;
	}
	public void setPositionY() {
		
	}
	
	public int get_width() {
		return _width;
	}

	public int get_height() {
		return _height;
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
	
}
