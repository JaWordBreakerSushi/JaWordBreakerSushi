package bricks;

import javax.swing.JPanel;

public class LetterBrick extends Brick{

	private static final long serialVersionUID = 1L;
	public char _letter;
	
	public LetterBrick(JPanel gameArea, TypeOfGift gift, char letter) {
		super(gameArea, gift);
		_letter = letter;
		super.set_letter(letter);
	}	
}
