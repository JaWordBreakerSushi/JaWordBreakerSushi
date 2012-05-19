package bricks;

import javax.swing.JPanel;

import game.Ball;
import game.Game;

public class BreakableBrick extends Brick{
	
	public BreakableBrick(JPanel gameArea, TypeOfGift gift) {
		super(gameArea, gift/*.getUrl()*/);
	}
}
