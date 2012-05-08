package bricks;

import game.Game;
import game.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager2;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel{
	private int _positionX;
	private int _positionY;
	private int _width;
	private int _height;
	/*Constructor*/
	public Brick(JPanel gameArea) {
		super();
		
		/*get the Panel for game*/		
		ImageIcon imgIcon = new ImageIcon("./src/img/maki.png");
		JLabel img = new JLabel(imgIcon);
		_width = imgIcon.getIconWidth();
		_height = imgIcon.getIconHeight();
		this.setVisible(true);
		this.add(img);
		this.setPositionX();
		this.setPositionY();
		//System.out.println(_positionX);
		
		//System.out.println("position : "+this.getLocation());
		
		this.setBounds(_positionX, _positionY, _width, _height);
		
		gameArea.add(this);
		
		this.setVisible(true);		
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
