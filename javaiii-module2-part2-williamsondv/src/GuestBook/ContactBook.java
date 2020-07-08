package GuestBook;

import javax.swing.SwingUtilities;

public class ContactBook {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
					new ContactViewController();
					ContactViewController contactView = new ContactViewController();
					contactView.add(contactView.anchorPane);
					contactView.setVisible(true);
			}
		});
		
		
		
		
		
	}
}
