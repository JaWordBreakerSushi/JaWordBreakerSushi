package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import bricks.*;


public class Game {
	
	/*Data*/
	private static int _width = 520;
	private static int _height = 480;
	
	/*About payer*/
	private static int _score = 0;
	
	/*Readed on scores ; dictionnary*/
	private ArrayList<String> _listOfWords = new ArrayList<String>();
	private LinkedList<Integer> _listOfScores = new LinkedList<Integer>();

	/**/
	private static String _selectedWord;
	private int _levelNumber;
	private static LinkedList<Brick> _listOfBrick = new LinkedList<Brick>();
	private static LinkedList<Ball> _listOfBall = new LinkedList<Ball>();
	private static PaletBrick _palet;
	private static boolean _start = false;
	private static JPanel _gameArea;
	
	
	public Game(JPanel gameArea) {
		
		_gameArea = gameArea;
		
		/*Create the main window*/
		
		_levelNumber = 1;
		/*SELECTIONNER LE MOT
		level 1 => 3lettres
		level 2 => 4lettres
		level n => n+2lettres*/
		this.prepareLevel(gameArea);
	}
	
	public void passToTheNextLevel() {
		_levelNumber++;
	}
	
	public void prepareLevel(JPanel gameArea){
		//System.out.println("AAAAAA");
		
		/*palet's Brick (just ONE)*/
		_palet = new PaletBrick(gameArea, TypeOfGift.PALET);
		/*init size*/
		_palet.set_width(_palet.get_width() / 2);
		_palet.display(this._width/2 - _palet.get_width()/2, this._height - _palet.get_height());
		
		/*Ball to start*/
		_listOfBall.add(new Ball(gameArea));
		_listOfBall.get(0).display(this._width/2 - (_listOfBall.get(0).get_width()/2), _palet.getPositionY() - _listOfBall.get(0).get_height());
		
		/*Depends of levelNumber*/
		_selectedWord = "TEST";
		
		/*letter's Bricks*/
		char letter;
		for(int i = 0; i < _levelNumber+3; i++) {
			letter = _selectedWord.charAt(i);
			_listOfBrick.add(new LetterBrick(gameArea, TypeOfGift.LETTER, letter));
		}
		
		/*ball's Bricks*/
		for(int i = 0; i < _levelNumber; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.BALL));
		}
		
		/*bonus' Bricks*/
		for(int i = 0; i < _levelNumber+3; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.BONUS));
		}
//		int widthLargestBrick = _listOfBrick.getLast().get_width();
//		int heightHigherBrick = _listOfBrick.getLast().get_height();
		//-1???
		int widthLargestBrick = 86;
		int heightHigherBrick = 44;
		/*magic's' Bricks*/
		for(int i = 0; i < _levelNumber+4; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.MAGIC));
		}
		
		/*temps' Bricks*/
		for(int i = 0; i < _levelNumber+1; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.TEMPORAL));
		}
		
		/*fixe's Bricks*/
		for(int i = 0; i < _levelNumber+4; i++) {
			_listOfBrick.add(new UnBreakableBrick(gameArea, TypeOfGift.FIXE));
		}	
			
		/*movable's Bricks*/
		for(int i = 0; i < _levelNumber+4; i++) {
			_listOfBrick.add(new UnBreakableBrick(gameArea, TypeOfGift.MOVABLE));
		}
		
		/*place bricks*/
		int bricksPerLine = (int)(this._width/widthLargestBrick) -1;
		int bricksPerCol = (int) (this._height/heightHigherBrick) -1;
		Brick brickToPlace = null;

		/*ligne and col*/
		int j = 0;
		int k = 0;
		boolean justPosisionnedABrick = false;
		for (int i =0; i <_listOfBrick.size(); ++i)
		{
			justPosisionnedABrick = false;
			do
			{
				int index = (int)(Math.random() * ((_listOfBrick.size() -0) - 0)) + 0;
				
				brickToPlace = _listOfBrick.get(index);
				if (!brickToPlace.is_isPositionned())
				{
					brickToPlace.display(k*widthLargestBrick, j*heightHigherBrick);
					brickToPlace.set_isPositionned(true);
					justPosisionnedABrick = true;
					k++;
					if (k >= bricksPerLine)
					{
						k = 0;
						j++;
					}
				}
			}
			while (!justPosisionnedABrick);
		}
		
		//_listOfBall.get(0).startBallTimer();
	}

	/*Getters and Setters*/
	
	public static JPanel get_gameArea() {
		return _gameArea;
	}
	
	public static String get_selectedWord() {
		return _selectedWord;
	}

	public void set_selectedWord(String selectedWord) {
		_selectedWord = selectedWord;
	}

	public static LinkedList<Brick> get_listOfBrick() {
		return _listOfBrick;
	}

	public void set_listOfBrick(LinkedList<Brick> listOfBrick) {
		_listOfBrick = listOfBrick;
	}

	public static LinkedList<Ball> get_listOfBall() {
		return _listOfBall;
	}

	public void set_listOfBall(LinkedList<Ball> listOfBall) {
		_listOfBall = listOfBall;
	}

	public static PaletBrick get_palet() {
		return _palet;
	}

	public void set_palet(PaletBrick palet) {
		_palet = palet;
	}

	public static int get_width() {
		return _width;
	}

	public void set_width(int width) {
		_width = width;
	}

	public static int get_height() {
		return _height;
	}

	public void set_height(int height) {
		_height = height;
	}

	public static int get_score() {
		return _score;
	}

	public static void set_score(int score) {
		_score = score;
	}

	public static boolean is_start() {
		return _start;
	}

	public static void set_start(boolean start) {
		_start = start;
	}	
}
