package bricks;

import javax.swing.JPanel;

import game.Ball;
import game.Game;

public class LetterBrick extends Brick{
	
	public char _letter;
	
	public LetterBrick(JPanel gameArea, TypeOfGift gift, char letter) {
		super(gameArea, gift/*.getUrl()*/);
		_letter = letter;
		super.set_letter(letter);
	}	
}
