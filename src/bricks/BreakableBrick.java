package bricks;

import javax.swing.JPanel;

import game.Ball;
import game.Game;

public class BreakableBrick extends Brick{
	
	public BreakableBrick(JPanel gameArea, TypeOfGift gift) {
		super(gameArea, gift/*.getUrl()*/);
		
		/*choice of gift*/
		int giftChosen = (int)(Math.random() * (5 -0) - 0) + 0;
		System.out.println(giftChosen);
		switch(giftChosen)
		{
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}
}
