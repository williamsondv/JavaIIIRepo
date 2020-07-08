package GuestBook;
import java.util.*;
import java.util.ArrayList;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Contact implements Comparable<Contact>{
	String fName = new String();
	String lName = new String();
	String address = new String();
	String phone = new String();
	static ArrayList<Contact> scrollpaneContacts = new ArrayList<Contact>();
	static StringBuilder sb = new StringBuilder();
	int contactCounter;
	
	public static ArrayList<Contact> getScrollpaneContacts() {
		return scrollpaneContacts;
	}

	public static void setScrollpaneContacts(ArrayList<Contact> scrollpaneContacts) {
		Contact.scrollpaneContacts = scrollpaneContacts;
	}

	//Contact constructor
	public Contact(String fName, String lName, String address, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		contactCounter++;
	}

	@Override
	public int compareTo(Contact o) {
		return (-(o.fName.compareTo(fName)));
	}
	

	//check for duplicate entries
	public static boolean duplicateEntryCheck(Contact c) {
		for(int i = 0; i < scrollpaneContacts.size(); i ++) {
			if(scrollpaneContacts.get(i).fName.contentEquals(c.fName) &&
			   scrollpaneContacts.get(i).lName.contentEquals(c.lName) &&
			   scrollpaneContacts.get(i).address.contentEquals(c.address) &&
			   scrollpaneContacts.get(i).phone.contentEquals(c.phone)) {
				return true;
			}
		}
		return false;
	}
	
	//generate and format string for textArea
	public static String textAreaStringFromArrayList(ArrayList<Contact> contactsList) {
		sb.setLength(0);
		String fNameTemp = new String();
		String lNameTemp = new String();
		String addressTemp = new String();
		String phoneTemp = new String();
		
		for (int i = 0; i < contactsList.size(); i++) {
			fNameTemp = contactsList.get(i).fName;
			lNameTemp = contactsList.get(i).lName;
			addressTemp = contactsList.get(i).address;
			phoneTemp = contactsList.get(i).phone;
			
			if (lNameTemp.contentEquals("")) {
				lNameTemp = "No Entry Provided";
			}
			if (addressTemp.contentEquals("")) {
				addressTemp = "No Entry Provided";
			}
			if (phoneTemp.contentEquals("")) {
				phoneTemp = "No Entry Provided";
			}
			
			
			sb.append("Contact " + (i+1) + ":" + "\n" + fNameTemp + "\n" + lNameTemp + "\n" + addressTemp + "\n" + phoneTemp + "\n" + "\n");
			
		}
		return sb.toString();
	}
	
	public static void sortContacts(ArrayList<Contact> contactsList) {
		java.util.Collections.sort(scrollpaneContacts);
	}
}
