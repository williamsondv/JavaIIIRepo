package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Driver;

public class RockPaperScissorsView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RockPaperScissorsView() {
		initUI();
	}

	float newSize = 70;
	public JPanel anchorPanel = new JPanel();
	JPanel labelBanner = new JPanel();
	public JPanel userSelection = new JPanel();
	public JPanel compSelection = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel throwPanel = new JPanel();
	JPanel spacingPanel = new JPanel();
	GridLayout layout = new GridLayout(0,3,20,20);
	
	static String text = new String("<HTML><font size = 20> Rock </HTML>"); 
	
	
	
	
	public static JButton rockButton = new JButton("Rock");
	public static JButton paperButton = new JButton("Paper");
	public static JButton scissorsButton = new JButton("Scissors");
	
	JLabel introLabel = new JLabel("Welcome! Please select your throw to play.");
	public static JLabel throwLabelUser = new JLabel(text);
	public static JLabel throwLabelComp = new JLabel(text);
	public static JLabel manInTheArenaLabel = new JLabel("Will you be defeated or forever live on in glory? Make a selection to dare greatly...");
	
	
	
	public void initUI() {
	
	setTitle("Rock, Paper, Scissors");
    setSize(600, 350);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    Dimension dimension = new Dimension(150,20);
   
    spacingPanel.setPreferredSize(dimension);
    
    manInTheArenaLabel.setBorder(new EmptyBorder(40,0,0,0));//top,left,bottom,right
    buttonPanel.setBorder(new EmptyBorder(40,15,15,15));//top,left,bottom,right
    
    buttonPanel.setLayout(layout);
    
    throwLabelUser.setHorizontalAlignment(SwingConstants.LEFT);
    throwLabelComp.setHorizontalAlignment(SwingConstants.RIGHT);
    
   
    anchorPanel.add(labelBanner);
    anchorPanel.add(throwPanel);
    throwPanel.add(userSelection);
    throwPanel.add(spacingPanel);
    throwPanel.add(compSelection);
    anchorPanel.add(buttonPanel);
    
    labelBanner.add(manInTheArenaLabel);
    userSelection.add(throwLabelUser);
    compSelection.add(throwLabelComp);
    buttonPanel.add(rockButton);
    
    buttonPanel.add(paperButton);
    
    buttonPanel.add(scissorsButton);
    
    anchorPanel.setVisible(true);
    labelBanner.setVisible(true);
    userSelection.setVisible(true);
    compSelection.setVisible(true);
    buttonPanel.setVisible(true);
    throwPanel.setVisible(true);
    
    anchorPanel.setLayout(new GridLayout(3,0,0,0));
   
    
	}
}
