
package numberconverter;

import static java.awt.BorderLayout.CENTER;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.border.EmptyBorder;
/**
 *
 * David Williamson
 */
public class Menu extends JFrame  {
    
    public Menu() {
        initUI();
    
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    
     //Main Menu
     JPanel panel = new JPanel(new GridLayout(1,600,10,0));
     //Selection Buttons
     JButton hexToDec = new JButton("Hex to Dec");
     JButton binToHex = new JButton("Bin to Hex");
     JButton binToDec = new JButton("Bin to Dec");
     JButton decToBin = new JButton("Dec to Bin");
     JButton decToHex = new JButton("Dec to Hex");
     JButton hexToBin = new JButton("Hex to Bin");
     Dimension maxSize = new Dimension (70,80);
     //ActionListener tied to all conversion buttons
     ActionListener menuAction = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
       String numConUserValue = JOptionPane.showInputDialog(null, "Please enter a value to be converted");
       if (e.getSource()==binToHex) {
       Binary bin = new Binary();
       bin.binaryToHexadecimal(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, bin.outputStringBH);
       } else if  (e.getSource()==binToDec) {
       Binary bin = new Binary();
       bin.binaryToDecimal(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, bin.outputStringBD);
       } else if (e.getSource()==decToHex) {
       Decimal dec = new Decimal();
       dec.decimalToHexadecimal(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, dec.getOutputStringDH());
       } else if (e.getSource()==decToBin) {
       Decimal dec = new Decimal();
       dec.decimalToBinary(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, dec.getOutputStringDB());
       } else if (e.getSource()==hexToDec) {
       Hexadecimal hex = new Hexadecimal();
       hex.hexadecimalToDecimal(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, hex.getOutputStringHD());
       } else if (e.getSource()==hexToBin) {
       Hexadecimal hex = new Hexadecimal();
       hex.hexadecimalToBinary(numConUserValue);
       JOptionPane.showMessageDialog(rootPane, hex.getOutputStringHB());
       }
       }
     };
     
    private void initUI() {
    
    setTitle("Number Converter");
    setSize(600,100);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    panel.setSize(600, 100);
    panel.setBorder(new EmptyBorder(10,10,10,10));
    //creating padding for buttons
    hexToDec.setMargin(new Insets(5,5,5,5));
    hexToBin.setMargin(new Insets(5,5,5,5));
    binToHex.setMargin(new Insets(5,5,5,5));
    binToDec.setMargin(new Insets(5,5,5,5));
    decToBin.setMargin(new Insets(5,5,5,5));
    decToHex.setMargin(new Insets(5,5,5,5));
    //Add buttons to panel and add actionListener
    binToHex.addActionListener(menuAction);
    panel.add(binToDec);
    binToDec.addActionListener(menuAction);
    panel.add(binToHex);
    panel.add(decToBin);
    decToBin.addActionListener(menuAction);
    panel.add(decToHex);
    decToHex.addActionListener(menuAction);
    panel.add(hexToBin);
    hexToBin.addActionListener(menuAction);
    panel.add(hexToDec);
    hexToDec.addActionListener(menuAction);
    
    }
    
}
