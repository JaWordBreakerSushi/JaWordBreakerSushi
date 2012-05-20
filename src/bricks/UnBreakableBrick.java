package bricks;

import javax.swing.JPanel;

import game.Ball;
import game.Game;

public class UnBreakableBrick extends Brick{
	
	public UnBreakableBrick(JPanel gameArea, TypeOfGift gift) {
		super(gameArea, gift/*.getUrl()*/);		
	}
}