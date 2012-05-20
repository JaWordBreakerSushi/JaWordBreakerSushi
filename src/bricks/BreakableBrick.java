package bricks;

import javax.swing.JPanel;

import game.Ball;
import game.Game;

public class BreakableBrick extends Brick{
	
	private int _typeOfGift;
	
	public BreakableBrick(JPanel gameArea, TypeOfGift gift) {
		super(gameArea, gift/*.getUrl()*/);
		
		/*choice of gift*/
		int giftChosen = (int)(Math.random() * (6 -0) - 0) + 0;
		_typeOfGift = giftChosen;
		super.set_typeOfGift(giftChosen);
	}
	
//	public void applicationOfGift() {
//		
//	}
}
