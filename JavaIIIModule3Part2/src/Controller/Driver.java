package Controller;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Paper;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import Model.Rock;
import Model.Scissors;
import View.RockPaperScissorsView;
import java.awt.*;

public class Driver {
	 Rock rock = new Rock();
	 Paper paper = new Paper();
	 Scissors scissors = new Scissors();
	 Object compSelectionThrow = new Object();
	 Object userSelectionThrow = new Object();
	 
	
	 Driver() {
		 
	 }
	
	
	 
	public void determineVictor(Object compPick, Object userPick){
		if (compPick == paper) {
			 RockPaperScissorsView.throwLabelComp.setText("<HTML><font size = 20> Paper </HTML>");
		} else if (compPick == scissors) {
			 RockPaperScissorsView.throwLabelComp.setText("<HTML><font size = 20> Scissors </HTML>");
		} else if (compPick == rock) {
			RockPaperScissorsView.throwLabelComp.setText("<HTML><font size = 20> Rock </HTML>");
		}
		
		if((compPick == rock && userPick == rock) || (compPick == paper && userPick == paper) || (compPick == scissors && userPick == scissors)) {
			 RockPaperScissorsView.manInTheArenaLabel.setText("Your efforts have resulted in a stalemate. Persevere and you will triumph.");
	    } else if ((compPick == paper && userPick == rock) || (compPick == scissors && userPick == paper) || (compPick == rock && userPick == scissors)) {
			 RockPaperScissorsView.manInTheArenaLabel.setText("<html>Your mighty engines of war and once proud armies have been swamped by the sheer numbers<br/> <div style = text align: center>of your enemy. Quantity has a quality all its own after all. Persevere and you will triumph.</div></html>");
	    } else if ((compPick == scissors && userPick == rock) || (compPick == paper && userPick == scissors) || (compPick == rock && userPick == paper)) {
			 RockPaperScissorsView.manInTheArenaLabel.setText("<html>Through valor, brutal efficiency, and cunning your brilliant defence has broken the back <br/><div style = text align: center> of the enemy forces. They will think twice before encroaching up your borders again.</div><html>");
	}
	}
	public  ActionListener buttonAction = new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
	    	 int compSelectionNumber = (int)(Math.random() * 3) + 1;
	    	 
	    	 switch (compSelectionNumber) {
	    	 case 1: compSelectionThrow = rock;
	    	 		 break;
	    	 case 2: compSelectionThrow = paper;
	 		         break;
	    	 case 3: compSelectionThrow = scissors;
	 		         break;
	    	 }
	    	 
	    	 
	    	 
	    	 if (e.getSource() == RockPaperScissorsView.rockButton) {
	    		 userSelectionThrow = rock;
	    		 RockPaperScissorsView.throwLabelComp.setText("<HTML><font size = 20> Rock </HTML>");
	    		 determineVictor(compSelectionThrow, userSelectionThrow);
	    		 
	    		 
	    	 } else if  (e.getSource() == RockPaperScissorsView.paperButton) {
	    		 userSelectionThrow = paper;
	    		 RockPaperScissorsView.throwLabelUser.setText("<HTML><font size = 20> Paper </HTML>");
	    		 determineVictor(compSelectionThrow, userSelectionThrow);
	    		 
	    	 } else if (e.getSource() == RockPaperScissorsView.scissorsButton) {
	    		 userSelectionThrow = scissors;
	    		 RockPaperScissorsView.throwLabelUser.setText("<HTML><font size = 20> Scissors </HTML>");
	    		 determineVictor(compSelectionThrow, userSelectionThrow);
	    	 }
	     
	     }
	     };
	     
	    
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
					new RockPaperScissorsView();
					RockPaperScissorsView rockPaperScissorsView = new RockPaperScissorsView();
					Driver driver = new Driver();
					RockPaperScissorsView.rockButton.addActionListener(driver.buttonAction);
					RockPaperScissorsView.paperButton.addActionListener(driver.buttonAction);
					RockPaperScissorsView.scissorsButton.addActionListener(driver.buttonAction);
					
					rockPaperScissorsView.add(rockPaperScissorsView.anchorPanel);
					rockPaperScissorsView.setVisible(true);
			}
		});
}
	}
