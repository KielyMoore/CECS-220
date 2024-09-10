//***********************************************************
// Contact.java          Author: Christopher Moore
// Problem 2 B           Date: 7/19/2020
//
// Class representing a phone contact, throws PhoneNumberException
//***********************************************************
public class Contact {

	private String Name, Phone;
	
	/*
	 * Constructor Accepting two arguments for instance variables
	 * Uses setter methods for instance variables
	 * throws PhoneNumberException form setPhone Method
	 */
	public Contact(String Name, String Phone) throws PhoneNumberException {
		setName(Name);
		setPhone(Phone);
	}

	//Set Name instance Variable
	public void setName(String Name) {
		this.Name = Name;
	}
	
	/*
	 * Sets the Phone Instance variable if an Exception is not thrown
	 * throws PhoneNumberException with appropriate message
	 * if the Phone is not formatted correctly
	 */
	public void setPhone(String Phone) throws PhoneNumberException {
		
		//Local Number
		if(Phone.length() == 8) {
			
			//throws a NumberFormatException if nonNumeric Characters
			Integer.parseInt(Phone.substring(0, 3));
			Integer.parseInt(Phone.substring(4));
			
			if(Phone.charAt(3) != '-') 
				throw new PhoneNumberException("Invalid Break");
			
			if(Phone.charAt(0) == '1') 
				throw new PhoneNumberException("Invalid First Digit of Local Number");	
		
		//Domestic
		} else if (Phone.length() == 12) {
			
			//throws a NumberFormatException if nonNumeric Characters
			Integer.parseInt(Phone.substring(0, 3));
			Integer.parseInt(Phone.substring(4, 7));
			Integer.parseInt(Phone.substring(8));
			
			if(Phone.charAt(3) != '-' || Phone.charAt(7) != '-') 
				throw new PhoneNumberException("Invalid Break(s)");
			
			if(Phone.charAt(4) == '1')
				throw new PhoneNumberException("Invalid First Digit of Local Number");
		
		} else throw new PhoneNumberException("Invalid Length");
		
		this.Phone = Phone;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public String toString() {
		return "Name: "+Name+"\nPhone: "+Phone;
	}
	
}
