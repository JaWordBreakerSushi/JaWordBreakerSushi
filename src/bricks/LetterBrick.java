package bricks;

import javax.swing.JPanel;

public class LetterBrick extends Brick{

	private static final long serialVersionUID = 1L;
	public char _letter;
	
	public LetterBrick(JPanel gameArea, TypeOfGift gift, char letter2) {
		
		super(gameArea, gift, letter2);
		_letter = letter2;
		super.set_letter(letter2);
	}	
}