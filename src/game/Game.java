package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import bricks.*;


public class Game {
	
	/*Readed on scores dictionnary*/
	private ArrayList<String> _listOfWords = new ArrayList<String>();
	private LinkedList<Integer> _listOfScores = new LinkedList<Integer>();

	/*FAIRE UNE Intern class?*/
	private String _selectedWord;
	private int _levelNumber;
	private static LinkedList<Brick> _listOfBrick = new LinkedList<Brick>();
	private LinkedList<Ball> _listOfBall = new LinkedList<Ball>();
	public boolean _start = false;
	/**/
	
	
	public Game(JPanel gameArea) {
		
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
		
		/*Depends of levelNumber*/
		_selectedWord = "TEST";		
		
		/*letter's Bricks*/
		for(int i = 0; i < _levelNumber+3; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.LETTER));
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
		//System.out.println("PLUS LARGE ET LONG" + widthLargestBrick + ";" + heightHigherBrick);
		/*magic's' Bricks*/
		for(int i = 0; i < _levelNumber+4; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.MAGIC));
		}
		
		/*temps' Bricks*/
		for(int i = 0; i < _levelNumber+1; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.TEMPORAL));
		}
		
		
		/*fixe's Bricks*/
		for(int i = 0; i < _levelNumber+8; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.FIXE));
		}	
			
		/*movable's Bricks*/
		for(int i = 0; i < _levelNumber+4; i++) {
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.MOVABLE));
		}
		
		/*place bricks*/
		int bricksPerLine = (int)(565/widthLargestBrick) -1;
		int bricksPerCol = (int) (565/heightHigherBrick) -1;
		Brick brickToPlace = null;

		/*ligne and col*/
		int j = 0;
		int k = 0;
		boolean justPosisionnedABrick = false;
		for (int i =0; i <_listOfBrick.size(); ++i)
		{
			justPosisionnedABrick = false;
			System.out.println(i);
			do
			{
				int index = (int)(Math.random() * ((_listOfBrick.size() -0) - 0)) + 0;
				
				brickToPlace = _listOfBrick.get(index);
				if (!brickToPlace.is_isPositionned())
				{
					System.out.println("Brique n° " + index);
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
		
		
		/*Ball*/
//		_listOfBall.add(new Ball(this));
		
		/*palet's Brick (just ONE)*/
		//NOoooooooON//_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.LETTER));
	
	}

	/*Getters and Setters*/
	
	public static LinkedList<Brick> get_listOfBrick() {
		return _listOfBrick;
	}

	public void set_listOfBrick(LinkedList<Brick> listOfBrick) {
		_listOfBrick = listOfBrick;
	}
}
