package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import bricks.*;


public class Game {
	
	/*Readed on scores dictionnary*/
	private ArrayList<String> _listOfWords = new ArrayList<String>();
	private LinkedList<Integer> _listOfScores = new LinkedList<Integer>();

	private MainWindow _gameInterface;
	/*FAIRE UNE Intern class?*/
	private String _selectedWord;
	private int _levelNumber;
	private LinkedList<Brick> _listOfBrick = new LinkedList<Brick>();
	private LinkedList<Ball> _listOfBall = new LinkedList<Ball>();
	/**/
	
	
	public Game() {
		
		/*Create the main window*/
		_gameInterface = new MainWindow();
		_gameInterface.showWindow();
		
		_levelNumber = 1;
		/*SELECTIONNER LE MOT
		 * level 1 => 3lettres
		 * level 2 => 4lettres
		 * level n => n+2lettres*/
		_selectedWord = "TEST";
		this.prepareLevel();
	}
	
	public void passToTheNextLevel() {
		_levelNumber++;
	}
	
	public void prepareLevel(){
		/*letter's Bricks*/
		for(int i = 0; i < _levelNumber+3; i++) {
			_listOfBrick.add(new BreakableBrick(this, TypeOfGift.LETTER));
		}
		
		/*Ball*/
		_listOfBall.add(new Ball(this));
	}

	/*Getters and Setters*/
	public MainWindow get_gameInterface() {
		return _gameInterface;
	}

	public void set_gameInterface(MainWindow gameInterface) {
		_gameInterface = gameInterface;
	}
	
	public LinkedList<Brick> get_listOfBrick() {
		return _listOfBrick;
	}

	public void set_listOfBrick(LinkedList<Brick> listOfBrick) {
		_listOfBrick = listOfBrick;
	}
}
