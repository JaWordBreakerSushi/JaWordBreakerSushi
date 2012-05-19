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
	private TypeOfGift _gift;
	
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

	
}
