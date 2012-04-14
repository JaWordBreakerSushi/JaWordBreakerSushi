package game;

import java.awt.Graphics;

public class Ball {
	private int _positionX;
	private int _positionY;
	private float _dX;
	private float _dY;
	private int _size;
	private float _masse;
	
	public Ball(Game game) {
		Graphics graphicInstance = game.get_gameInterface().get_panel().getGraphics();
		_positionX = game.get_gameInterface().get_panel().getWidth()/2;
		_positionY = game.get_gameInterface().get_panel().getHeight() - 40;
		_size = 20;
		graphicInstance.fillOval(_positionX, _positionY, _size, _size);
	}
}
