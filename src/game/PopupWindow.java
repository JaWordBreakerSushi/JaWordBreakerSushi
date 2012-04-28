package game;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class PopupWindow extends JPanel {

    private JFrame popupWindow;
    private JTextField wordProposed;

    /**
     * Constructor.
     */
    public PopupWindow() {
        init();
    }
    
    /**
     * Initialiser.
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
        JPanel pausePanelBottom = new JPanel();
        
        popupWindow.getContentPane().setPreferredSize(new Dimension(400, 200));
        pausePanelTop.setPreferredSize(new Dimension(400, 75));
        pausePanelBottom.setPreferredSize(new Dimension(400, 115));
        
        Font fontName = new Font("Arial", Font.BOLD, 18);
        JLabel title = new JLabel("Pause");
        title.setPreferredSize(new Dimension(350, 35));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(fontName);
        title.setForeground(Color.WHITE);
        
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
            }        	
        });
        
        pausePanelTop.add(title);
        pausePanelBottom.add(word);
        pausePanelBottom.add(wordProposed);
        popupWindow.getContentPane().add(pausePanelTop, BorderLayout.NORTH);
        popupWindow.getContentPane().add(pausePanelBottom, BorderLayout.CENTER);
        popupWindow.pack();
    }
    
    public JFrame get_popupWindow(){
    	return popupWindow;
    }
    


}
