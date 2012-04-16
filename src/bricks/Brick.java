package bricks;

import game.Game;
import game.ImagePanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Brick extends JFrame{
	private int _positionX;
	private int _positionY;
	private int _width;
	private int _height;
	/*Constructor*/
	public Brick(Game game) {
		ImagePanel img = new ImagePanel("./src/img/maki.png");		
		JPanel gameArea = game.get_gameInterface().get_panel();
		gameArea.add(img);
	}
	
	/*GETTERS AND SETTERS*/
	public int getPositionX() {
		return _positionX;
	}
	public void setPositionX() {
		this._positionX = (int)(Math.random() * ((600 -_width) - _width)) + _width;
	}
	public int getPositionY() {
		return _positionY;
	}
	public void setPositionY() {
		this._positionY = (int)(Math.random() * ((800 - _height)- (_height + 100) )) + _height;
	}
}
