package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

import bricks.Brick;

public class Interface extends JFrame {
	
	private JPanel _gameArea;
	private Game _gameData;
    private PopupWindow popup;
	public Container _content = getContentPane();
	private JPanel _scoreList;
	private static JLabel _score;
	private static JLabel _letters;
	private static JLabel _nbBalls;
	private static Color jaune = new Color(255,213,91);
	private static Color orange = new Color(253,111,15);
	
	private AudioClip sound;  
	private Applet applet = new Applet();
	
	private LinkedList<String> _dico;
	private String _wordChosen;
	
	public static void main(String[] args){
		
		//AudioSound as =  new AudioSound();
		Interface game = new Interface();
	}

	public Interface(){
		
		URL base = applet.getClass().getResource("/welcome.wav"); 
	    System.out.print(base);
        // load sounds and set currentSound
	    sound = applet.getAudioClip(base, "welcome.wav");
	    //sound.play();
		
		try {
			readDico();
		}
		catch (IOException e){
			System.out.println("IOException " + e.getMessage());
		}
		
		_wordChosen = chooseWordFromDico();
		
		setTitle("JaWordBreaker Sushi");
		setSize(800, 586);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 _content.setFocusable(true);
		startInterface();
	}
	
	public void startInterface(){
			
		_content.setLayout(new BorderLayout(0,0));
		_content.setBackground(jaune);
		
		JPanel menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		menu.setBackground(jaune);
		
		Font fontScore = new Font("Arial", Font.BOLD, 18);
		
        JLabel title = new JLabel(new ImageIcon("./src/img/logo.jpg"));
        title.setPreferredSize(new Dimension(800, 240));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(fontScore);
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,110,0),title.getBorder()));
        
		JLabel borderBottomBackground = new JLabel(new ImageIcon("./src/img/border_bottom_home.jpg"));
        
        JButton start = new JButton(new ImageIcon("./src/img/btn_normal_start.jpg"));
		start.setPreferredSize(new Dimension(258, 47));
		start.setFont(fontScore);
		start.setForeground(Color.WHITE);
		start.setAlignmentX((float)0.5);
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		start.setBorder(null);
		start.setMargin(new Insets(0, 0, 0, 0));
		start.setRolloverIcon(new ImageIcon("./src/img/btn_hover_start.jpg"));
		
        JLabel emptyLabel = new JLabel(" ");

		JButton highScores = new JButton(new ImageIcon("./src/img/btn_normal_hs.jpg"));
		highScores.setPreferredSize(new Dimension(258, 47));
		highScores.setFont(fontScore);
		highScores.setForeground(Color.WHITE);
		highScores.setAlignmentX((float)0.5);
		highScores.setCursor(new Cursor(Cursor.HAND_CURSOR));
		highScores.setBorder(null);
		highScores.setMargin(new Insets(0, 0, 0, 0));
		highScores.setRolloverIcon(new ImageIcon("./src/img/btn_hover_hs.jpg"));
		
		start.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	_content.removeAll();  
            	playingInterface();
            }
        });  
		
		highScores.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	_content.removeAll();
            	highScoresInterface();
            }
        }); 
		
		menu.add(start);
		menu.add(emptyLabel);
		menu.add(highScores);
		_content.add(menu, BorderLayout.CENTER);
		_content.add(title, BorderLayout.NORTH);
		_content.add(borderBottomBackground, BorderLayout.SOUTH);
		
        this.setContentPane(_content);
        this.setVisible(true);
	}
	
	public void playingInterface(){
				
		_content.setLayout(new BoxLayout(_content, BoxLayout.X_AXIS));
        
        JPanel gamePanel = new JPanel(new BorderLayout(0,0));
        _gameArea = new JPanel ();
        _gameArea.setLayout(null);
       //_gameArea.setLayout(new GridBagLayout());
       //_gameArea.setLayout(new GridLayout(3, 2, 5, 5));
        
		_gameData = new Game(_gameArea);
        
        JPanel borderTop = new JPanel();
        JPanel borderLeft = new JPanel();
        JPanel borderRight = new JPanel();
        JPanel borderBottom = new JPanel();
        JLabel borderTopBackground = new JLabel(new ImageIcon("./src/img/border_top.gif"));
        JLabel borderLeftBackground = new JLabel(new ImageIcon("./src/img/border_left.gif"));
        JLabel borderRightBackground = new JLabel(new ImageIcon("./src/img/border_right.gif"));
        JLabel borderBottomBackground = new JLabel(new ImageIcon("./src/img/border_bottom.jpg"));
        
        ImagePanel menu = new ImagePanel("./src/img/background_menu.jpg");
        
        /*Display in right panel*/
        Font fontName = new Font("Arial", Font.BOLD, 18);
        Font fontScore = new Font("Arial", Font.BOLD, 15);
        JLabel name = new JLabel("Amethyste");
        name.setPreferredSize(new Dimension(180, 35));
        name.setHorizontalAlignment(JLabel.LEFT);
        name.setFont(fontName);
        name.setForeground(Color.WHITE);
        
        /*Current Score*/
        _score = new JLabel();
        _score.setPreferredSize(new Dimension(180, 25));
        _score.setHorizontalAlignment(JLabel.LEFT);
        _score.setFont(fontScore);
        _score.setForeground(Color.WHITE);
        _score.setText("Score : " + _gameData.get_score());
        
        /*Current number of balls*/
        _nbBalls = new JLabel();
        _nbBalls.setPreferredSize(new Dimension(180, 25));
        _nbBalls.setHorizontalAlignment(JLabel.LEFT);
        _nbBalls.setFont(fontScore);
        _nbBalls.setForeground(Color.WHITE);
        _nbBalls.setText("Ball : 0");
        
        /*Known letters*/
        _letters = new JLabel();
        _letters.setPreferredSize(new Dimension(180, 25));
        _letters.setHorizontalAlignment(JLabel.LEFT);
        _letters.setFont(fontScore);
        _letters.setForeground(Color.WHITE);
        _letters.setText("Letters :");        
        
        borderTop.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderLeft.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderRight.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderBottom.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        gamePanel.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        _gameArea.setBorder(new EmptyBorder(-5, -5, -5, -5) );

        _gameArea.setBackground(new Color(247,217,129));
        //System.out.println(gamePanel.getSize()); //500 * 500
        
        borderTop.add(borderTopBackground);
        borderLeft.add(borderLeftBackground);
        borderRight.add(borderRightBackground);
        borderBottom.add(borderBottomBackground);
        gamePanel.add(borderTop, BorderLayout.NORTH);
        gamePanel.add(borderLeft, BorderLayout.WEST);
        gamePanel.add(borderRight, BorderLayout.EAST);
        gamePanel.add(borderBottom, BorderLayout.SOUTH);
        //gamePanel.setBackground(Color.BLUE);
        gamePanel.add(_gameArea, BorderLayout.CENTER);
        _content.add(gamePanel);
        menu.add(name);
        menu.add(_score);
        menu.add(_nbBalls);
        menu.add(_letters);

        _content.add(menu);
        
        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
            	//System.out.println(keyEvent.getKeyCode());
              if(KeyEvent.getKeyText(keyEvent.getKeyCode()) == "Espace"){
            	  popup = new PopupWindow(_wordChosen);
            	  JFrame popupWindow = popup.get_popupWindow();
            	  if(!popupWindow.isVisible()){
	            	  popupWindow.setVisible(true);
	            	  popupWindow.setLocationRelativeTo(null);
            	  }
              }
              //Enter
              if (keyEvent.getKeyCode() == 10)
              {
            	  if (_gameData.get_listOfBall().size() > 0)
            	  {
            		  _gameData.get_listOfBall().getFirst().startBallTimer();
            	  }
              }
              //a
              if(keyEvent.getKeyCode() == 65)
              {
              }
            }

            public void keyReleased(KeyEvent keyEvent) {}
            public void keyTyped(KeyEvent keyEvent) {}

        };
        
        _content.addKeyListener(keyListener);
        
        KeyListener keyListenerFleche = new KeyListener()
		{
	        public void keyPressed(KeyEvent keyEvent)
	        {
	        	if (keyEvent.getKeyCode() == 39)
	        	{
	        		//right
	        		if( _gameData.get_palet().getPositionX() < _gameData.get_width() - _gameData.get_palet().get_width())
	        		{
	        			_gameData.get_palet().display(_gameData.get_palet().getPositionX() +6, _gameData.get_palet().getPositionY());
	        		}
	        	}
	        	if (keyEvent.getKeyCode() == 37)
	        	{
	        		//left
	        		if( _gameData.get_palet().getPositionX() > 0)
	        		{
	        			_gameData.get_palet().display(_gameData.get_palet().getPositionX() -6, _gameData.get_palet().getPositionY());
	        		}
	        	}
	        }

	        public void keyReleased(KeyEvent keyEvent) {}
	        public void keyTyped(KeyEvent keyEvent) {}

	    };
	    _content.addKeyListener(keyListenerFleche);    
        
        this.setContentPane(_content);
        this.setVisible(true);
	}
	
	public void highScoresInterface(){
		_content.setLayout(new BorderLayout(0,0));
		_content.setBackground(jaune);
		
		JPanel head = new JPanel();
		head.setLayout(new BoxLayout(head, BoxLayout.Y_AXIS));
		head.setBackground(jaune);
		
		JLabel title = new JLabel(new ImageIcon("./src/img/logo.jpg"));
        title.setPreferredSize(new Dimension(800, 100));
        title.setAlignmentX((float)0.5);
		title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(34,0,25,0),title.getBorder()));
		
		Font fontSubtitle = new Font("Arial", Font.BOLD, 20);
		JLabel subtitle = new JLabel("--------------------------------- High Scores ---------------------------------");
		subtitle.setPreferredSize(new Dimension(800, 75));
		subtitle.setAlignmentX((float)0.5);
		subtitle.setFont(fontSubtitle);
		subtitle.setForeground(Color.WHITE);

		JPanel menu = new JPanel();
		menu.setBackground(jaune);
		
		Font fontTitleTab = new Font("Arial", Font.BOLD, 18);
		_scoreList = new JPanel(new GridLayout(11,3));
		_scoreList.setBackground(jaune);
		
		JLabel rank = new JLabel("Rank");
		rank.setFont(fontTitleTab);
		rank.setForeground(orange);
		JLabel name = new JLabel("Name");
		name.setFont(fontTitleTab);
		name.setForeground(orange);
		JLabel score = new JLabel("Score");
		score.setFont(fontTitleTab);
		score.setForeground(orange);
		
		_scoreList.add(rank);
		_scoreList.add(name);
		_scoreList.add(score);
		
		try {
			readScores();
		}
		catch (IOException e){
			System.out.println("IOException " + e.getMessage());
		}

		Border thickBorder = new LineBorder(Color.BLUE, 7);
		Font fontScore = new Font("Arial", Font.BOLD, 18);
		
		JButton retour = new JButton("Retour");
		retour.setFont(fontScore);
		retour.setForeground(Color.WHITE);
		retour.setBackground(Color.BLUE); 
		//retour.setBorder(thickBorder);
		

		retour.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	_content.removeAll();  
            	startInterface();
            }
        }); 
		
		JLabel borderBottomBackground = new JLabel(new ImageIcon("./src/img/border_bottom_home.jpg"));
		
		menu.add(retour);
		head.add(title);
		head.add(subtitle);
		_content.add(menu, BorderLayout.WEST);
		_content.add(_scoreList, BorderLayout.CENTER);
		_content.add(head, BorderLayout.NORTH);
		_content.add(borderBottomBackground, BorderLayout.SOUTH);
		
        this.setContentPane(_content);
        this.setVisible(true);
	}
	
	public JPanel get_gameArea(){
		return _gameArea;
	}
	
	public void readScores() throws IOException {
		
		File f = new File("./highScores.txt");
		InputStream in = new FileInputStream(f);
		
		DataInputStream dataIn = new DataInputStream(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(dataIn));
		String strLine;
		int rank = 1;
		
		while((strLine = br.readLine()) != null){ 
			
			String name = strLine;
			strLine = br.readLine();
			String score = strLine;
			
			if(strLine != null){
				Font font = new Font("Arial", Font.BOLD, 14);
				
				JLabel nameLabel = new JLabel(name);
				nameLabel.setFont(font);
				nameLabel.setForeground(Color.WHITE);
				
				JLabel scoreLabel = new JLabel(score);
				scoreLabel.setFont(font);
				scoreLabel.setForeground(Color.WHITE);
				
				JLabel rankLabel = new JLabel(Integer.toString(rank));
				rankLabel.setFont(font);
				rankLabel.setForeground(Color.WHITE);

				_scoreList.add(rankLabel);
				_scoreList.add(nameLabel);
				_scoreList.add(scoreLabel);
				
				++rank;
				
			}
			else {
				if(rank < 10){
					for(; rank<13; ++rank){
						_scoreList.add(new JLabel(" "));
					}
				}
			}
		}
		dataIn.close();
	}	
	
	public void readDico() throws IOException {
		
		File f = new File("./dico.txt");
		InputStream in = new FileInputStream(f);
		
		DataInputStream dataIn = new DataInputStream(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(dataIn));
		String strLine;
		_dico = new LinkedList<String>();
		
		while((strLine = br.readLine()) != null){ 
			
			_dico.add(strLine);
			
		}
		
		dataIn.close();
	}
	
	/*Getters and Setters*/

	public static void displayLetter(char letter) {
      _letters.setText(_letters.getText() + "  \n" + letter);
	}
	
    public String chooseWordFromDico(){
    	Random randomGenerator = new Random();
    	int index = randomGenerator.nextInt(_dico.size());
    	
    	return _dico.get(index);
    }
    	
	public static void displayNbBalls(int nb) {
		/*nb without the current ball*/
	      _nbBalls.setText("Ball : " + (nb-1));
		}
	
	public static void displayScore(int score) {
		_score.setText("Score : " + score);
	}	
}
