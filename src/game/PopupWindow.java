package game;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class PopupWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame popupWindow;
    private JTextField wordProposed;
    private String _wordChosen;
    public JLabel result;
	private static Color orange = new Color(253,111,15);

    /**
     * Constructor.
     */
    public PopupWindow(String word) {
    	_wordChosen = word;
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
        
        JLabel word = new JLabel("_ _ _ _ _ _ _");
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
                	/*Next level*/
                	Game.passToTheNextLevel();
                }
                else{
                	result.setText("Sorry, you don't found the right word. Try again!");
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
    
    public JFrame get_popupWindow(){
    	return popupWindow;
    }
}
