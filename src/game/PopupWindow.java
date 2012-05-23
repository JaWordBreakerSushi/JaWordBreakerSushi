package game;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class PopupWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame popupWindow;
    private JTextField wordProposed;
    private static String _wordChosen;
    public JLabel result;
    private JLabel word;
	private static JLabel _score;
	private static Color orange = new Color(253,111,15);
	private String _letters;

    /**
     * Constructor.
     */

    public PopupWindow() {
        init();
    }
    
    /**
     * Init.
     */
    private void init() {
        // use frame
        popupWindow = new JFrame();
        popupWindow.setLocationRelativeTo(null);
        popupWindow.setUndecorated(true);

        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
              if(KeyEvent.getKeyText(keyEvent.getKeyCode()) == "Espace"){
            	  if(popupWindow.isVisible()){
	            	  popupWindow.setVisible(false);
	            	  Game.set_start(true);
            	  }
              }
            }

            public void keyReleased(KeyEvent keyEvent) {}
            public void keyTyped(KeyEvent keyEvent) {}

        };
          
        popupWindow.addKeyListener(keyListener);
        popupWindow.setFocusable(true);

        // add some components to window
        popupWindow.getContentPane().setLayout(new BorderLayout());
        JPanel pausePanelTop = new JPanel();
        JPanel pausePanelCenter = new JPanel();
        JPanel pausePanelBottom = new JPanel();
        
        pausePanelTop.setBackground(orange);
        pausePanelCenter.setBackground(orange);
        pausePanelBottom.setBackground(orange);
        
        popupWindow.getContentPane().setPreferredSize(new Dimension(400, 200));
        pausePanelTop.setPreferredSize(new Dimension(400, 35));
        pausePanelCenter.setPreferredSize(new Dimension(400, 65));
        pausePanelBottom.setPreferredSize(new Dimension(400, 100));
        
        Font fontName = new Font("Arial", Font.BOLD, 18);
        JLabel title = new JLabel("Pause");
        title.setPreferredSize(new Dimension(350, 35));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(fontName);
        title.setForeground(Color.WHITE);
        
        result = new JLabel("");
        result.setPreferredSize(new Dimension(350, 65));
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setForeground(Color.WHITE);
        
        word = new JLabel("Votre mot :");
        word.setPreferredSize(new Dimension(350, 35));
        word.setHorizontalAlignment(JLabel.CENTER);
        word.setFont(fontName);
        word.setForeground(Color.WHITE);
        
        wordProposed = new JTextField(15);
        wordProposed.requestFocus();
        wordProposed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String text = wordProposed.getText();
                if(text.equals(_wordChosen)){
                	result.setText("Congratulations! You find the right word!");
                	wordProposed.setText("");

                	int score = Game.get_score();
                	score += 100;
                	Game.set_score(score);
                	game.Interface.displayScore(score);

                	/*Next level*/
                	Game.passToTheNextLevel();
                	
                }
                else{
                	result.setText("Sorry, you don't found the right word. Try again!");
                	int score = Game.get_score();
                	score -= 20;
                	Game.set_score(score);
                	game.Interface.displayScore(score);
                }
                popupWindow.requestFocusInWindow();
            } 

        });
        
        pausePanelTop.add(title);
        pausePanelCenter.add(result);
        pausePanelBottom.add(word);
        pausePanelBottom.add(wordProposed);
        popupWindow.getContentPane().add(pausePanelTop, BorderLayout.NORTH);
        popupWindow.getContentPane().add(pausePanelCenter, BorderLayout.CENTER);
        popupWindow.getContentPane().add(pausePanelBottom, BorderLayout.SOUTH);
        popupWindow.pack();
    }
    
    /*Getters and setters*/
    
    public JFrame get_popupWindow(){
    	return popupWindow;
    }

	public JTextField getWordProposed() {
		return wordProposed;
	}

	public void setWordProposed(JTextField wordProposed) {
		this.wordProposed = wordProposed;
	}

	public static String get_wordChosen() {
		return _wordChosen;
	}

	public static void set_wordChosen(String wordChosen) {
		_wordChosen = wordChosen;
	}

}
