package bricks;

import javax.swing.JPanel;

public class BreakableBrick extends Brick{

	private static final long serialVersionUID = 1L;
	
	public BreakableBrick(JPanel gameArea, TypeOfGift gift) {
		super(gameArea, gift);
		
		/*choice of gift*/
		int giftChosen = (int)(Math.random() * (6 -0) - 0) + 0;
		super.set_typeOfGift(giftChosen);
	}
}
