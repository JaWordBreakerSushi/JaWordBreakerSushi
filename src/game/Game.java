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
	private LinkedList<Brick> _listOfBrick = new LinkedList<Brick>();
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
			System.out.println("APPEL BRIQUE");
			_listOfBrick.add(new BreakableBrick(gameArea, TypeOfGift.LETTER));
		}
		
		/*Ball*/
//		_listOfBall.add(new Ball(this));
	}

	/*Getters and Setters*/
	
	public LinkedList<Brick> get_listOfBrick() {
		return _listOfBrick;
	}

	public void set_listOfBrick(LinkedList<Brick> listOfBrick) {
		_listOfBrick = listOfBrick;
	}
}
