package game;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame{
	
	private JPanel _gameArea;
	
	public static void main(String[] args){
		Interface game = new Interface();
	}

	public Interface(){

		this.setTitle("Kawaii JaWordBreaker");
		this.setSize(800, 586);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        
        JPanel gamePanel = new JPanel(new BorderLayout(0,0));
        _gameArea = new JPanel();
        JPanel borderTop = new JPanel();
        JPanel borderLeft = new JPanel();
        JPanel borderRight = new JPanel();
        JPanel borderBottom = new JPanel();
        JLabel borderTopBackground = new JLabel(new ImageIcon("./src/img/border_top.gif"));
        JLabel borderLeftBackground = new JLabel(new ImageIcon("./src/img/border_left.gif"));
        JLabel borderRightBackground = new JLabel(new ImageIcon("./src/img/border_right.gif"));
        JLabel borderBottomBackground = new JLabel(new ImageIcon("./src/img/border_bottom.jpg"));
        
        ImagePanel menu = new ImagePanel("./src/img/background_menu.jpg");
        Font fontName = new Font("Arial", Font.BOLD, 18);
        Font fontScore = new Font("Arial", Font.BOLD, 15);
        JLabel name = new JLabel("Amethyste");
        name.setPreferredSize(new Dimension(180, 35));
        name.setHorizontalAlignment(JLabel.LEFT);
        name.setFont(fontName);
        name.setForeground(Color.WHITE);
        
        JLabel score = new JLabel("Score : ");
        score.setPreferredSize(new Dimension(180, 25));
        score.setHorizontalAlignment(JLabel.LEFT);
        score.setFont(fontScore);
        score.setForeground(Color.WHITE);
        
        borderTop.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderLeft.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderRight.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        borderBottom.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        gamePanel.setBorder(new EmptyBorder(-5, -5, -5, -5) );
        _gameArea.setBorder(new EmptyBorder(-5, -5, -5, -5) );

        _gameArea.setBackground(new Color(247,217,129));
       
        borderTop.add(borderTopBackground);
        borderLeft.add(borderLeftBackground);
        borderRight.add(borderRightBackground);
        borderBottom.add(borderBottomBackground);
        gamePanel.add(borderTop, BorderLayout.NORTH);
        gamePanel.add(borderLeft, BorderLayout.WEST);
        gamePanel.add(borderRight, BorderLayout.EAST);
        gamePanel.add(borderBottom, BorderLayout.SOUTH);
        gamePanel.add(_gameArea, BorderLayout.CENTER);
        content.add(gamePanel);
        menu.add(name);
        menu.add(score);
        content.add(menu);
        
        this.setContentPane(content);
		
        this.setVisible(true);
	}
	
	public void init(){
		
	}
	
	public JPanel get_gameArea(){
		return _gameArea;
	}
	
}
