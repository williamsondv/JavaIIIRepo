package GuestBook;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ContactViewController extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactViewController() {
		initUI();
	}
	
	//create JPanels and JOptionPane
	JPanel anchorPane = new JPanel();
	JPanel panelPane = new JPanel();
	JPanel customerInformationPane = new JPanel();
	JPanel contactsScrollPane = new JPanel();
	JPanel submitButtonPane = new JPanel();
	JPanel spacingPane = new JPanel();
	JOptionPane duplicateEntryAlert = new JOptionPane();
	
	//create textFields
	JTextField firstNameTextField = new JTextField();
	JTextField lastNameTextField = new JTextField();
	JTextField addressTextField = new JTextField();
	JTextField phoneTextField = new JTextField();
	
	//create Labels for textFields
	JLabel firstNameLabel = new JLabel("First Name",JLabel.CENTER);
	JLabel lastNameLabel = new JLabel("Last Name",JLabel.CENTER);
	JLabel addressLabel = new JLabel("Address",JLabel.CENTER);
	JLabel phoneLabel = new JLabel("Phone Number",JLabel.CENTER);
	
	//create JButton
	JButton submitButton = new JButton("Submit");
	
	//create scrollPane, textArea and contactsArrayList for scrollPane
	JTextArea textArea = new JTextArea(8,30);
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	
	public void initUI() {
		
		setTitle("Contact Book");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
      //add scrollPane to contactScrollPane and submitButton to submitButton Pane
      		contactsScrollPane.add(scrollPane);
      		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      		submitButtonPane.add(submitButton);
      		
        
        //set layouts for cosmetics
        anchorPane.setLayout(new GridLayout(2,0,0,0));
        customerInformationPane.setLayout(new GridLayout(4,8));
        
		//add panelPane to anchorPane and other panels to panelPane
        anchorPane.add(panelPane);
		panelPane.add(customerInformationPane);
		panelPane.add(contactsScrollPane);
		anchorPane.add(submitButtonPane);
		
		//center submitButton in submitButtonPane
		submitButtonPane.setLayout(new GridBagLayout());

		
		
		
		//add labels and textFields to customerInformationPane
		customerInformationPane.add(firstNameLabel);
		customerInformationPane.add(firstNameTextField);
		customerInformationPane.add(lastNameLabel);
		customerInformationPane.add(lastNameTextField);
		customerInformationPane.add(addressLabel);
		customerInformationPane.add(addressTextField);
		customerInformationPane.add(phoneLabel);
		customerInformationPane.add(phoneTextField);
		
		
		
		//set panes visible
		anchorPane.setVisible(true);
		panelPane.setVisible(true);
		submitButtonPane.setVisible(true);
		customerInformationPane.setVisible(true);
		contactsScrollPane.setVisible(true);
		scrollPane.setVisible(true);
		
		//set default for textFields to empty string
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		addressTextField.setText("");
		phoneTextField.setText("");
		
		
		
		//set borders for textFields(padding)
		phoneLabel.setBorder(BorderFactory.createCompoundBorder(
		        phoneTextField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		firstNameLabel.setBorder(BorderFactory.createCompoundBorder(
		        phoneTextField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		lastNameLabel.setBorder(BorderFactory.createCompoundBorder(
		        phoneTextField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		addressLabel.setBorder(BorderFactory.createCompoundBorder(
		        phoneTextField.getBorder(), 
		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		//set up action listener for submitButton
		 ActionListener submitButtonAction = new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		     String fName = new String();
		     String lName = new String();
		     String address = new String();
		     String phone = new String();
		     
		     //get values from textFields
		     fName = firstNameTextField.getText();
		     lName = lastNameTextField.getText();
		     address = addressTextField.getText();
		     phone = phoneTextField.getText();
		     
		     //store text to arrayList as contact object with duplicate and firstName valid check
		     Contact newContact = new Contact(fName, lName, address, phone);
		     if(newContact.fName.equals("") || newContact.fName.equals(null)) {
		    	 firstNameTextField.setText("");
		 		 lastNameTextField.setText("");
		 		 addressTextField.setText("");
		 		 phoneTextField.setText("");
		    	 JOptionPane.showMessageDialog(null, "A first name is required. Please try again.");
		     } else if (Contact.duplicateEntryCheck(newContact)) {
		    	 firstNameTextField.setText("");
		 		 lastNameTextField.setText("");
		 		 addressTextField.setText("");
		 		 phoneTextField.setText("");
		 		 JOptionPane.showMessageDialog(null, "You have created a duplicate entry. Please try again.");
		     } else if (Contact.duplicateEntryCheck(newContact) == false) {
		    	 Contact.getScrollpaneContacts().add(newContact);
		    	 Contact.sortContacts(Contact.getScrollpaneContacts());
		    	 textArea.setText(Contact.textAreaStringFromArrayList(Contact.getScrollpaneContacts()));
		     }}};
		     submitButton.addActionListener(submitButtonAction);
		 };
		     
		    
		     
	
}
