package bricks;

import game.Game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick {
	private int _positionX;
	private int _positionY;
	private int _width = /*87*/200;
	private int _height = /*54*/100;
	/*Constructor*/
	public Brick(Game game) {
		try {
            Image img = ImageIO.read(new File("./src/img/sushiBrickTest.png"));
            Graphics graphicInstance = game.get_gameInterface().get_panel().getGraphics();
            //Background image
            
            /*test the possible position*/            	
            	//for(int i = 0; i < game.get_listOfBrick().size() ; i++) {
            int index = game.get_listOfBrick().size();
            System.out.println(index);
            this.setPositionX(0);
            this.setPositionY(0);
            boolean AreTooCloseX = true;
            boolean AreTooCloseY = true;

            if (index > 0) {
	            while(AreTooCloseX) {
	             	this.setPositionX(0);
	               	if(_positionX < game.get_listOfBrick().get(index - 1)._positionX + _width/2 && _positionX > game.get_listOfBrick().get(index - 1)._positionX - _width/2) {
	               		this.setPositionX(0);
	             		//System.out.println("DANS IF X");
	                }
	                else {
	                	AreTooCloseX = false;
	                }
	            }
	            
	            while(AreTooCloseY) {
	            	this.setPositionY(0);
	               	if(_positionY < game.get_listOfBrick().get(index-1)._positionY + _height/2 && _positionY > game.get_listOfBrick().get(index-1)._positionY - _height/2) {
	               		this.setPositionY(0);
	               		//System.out.println("DANS IF Y");
	              	}
	               	else {
	               		AreTooCloseY = false;
	               	}
	            }	
            }
            System.out.println(_positionX + ";" + _positionY);
            graphicInstance.drawImage(img, _positionX, _positionY, _width, _height, game.get_gameInterface().get_panel());
            
        }
		catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	/*GETTERS AND SETTERS*/
	public int getPositionX() {
		return _positionX;
	}
	public void setPositionX(int positionX) {
		this._positionX = (int)(Math.random() * ((600 -_width) - _width)) + _width;;
	}
	public int getPositionY() {
		return _positionY;
	}
	public void setPositionY(int positionY) {
		this._positionY = (int)(Math.random() * ((800 - _height)- (_height + 100) )) + _height;;
	}
}
