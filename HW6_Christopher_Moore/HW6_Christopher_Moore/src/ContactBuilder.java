import java.util.Scanner;
//***********************************************************
//ContactBuilder.java          Author: Christopher Moore
//Problem 2 C                  Date: 7/19/2020
//
// User creates a list of 10 contacts and Handles Exceptions
//***********************************************************
public class ContactBuilder {

	static Contact[] list;
	static int count;
	
	/*
	 * Allows the user to create a list of 10 contact objects
	 * Handles errors when setting the phone variable of the object
	 * Displays the contents of the contacts list
	 */
	public static void main(String[] args) {
		
		list = new Contact[10];
		count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter " + list.length + " Contacts");
		
		while(count < list.length) {
			Contact contact;
			
			//Accepts inputs for the variables of the contact object
			String name, phone;
			System.out.print("Enter Contact Name: ");
			name = scan.next();
			System.out.print("Enter Phone Number: ");
			phone = scan.next(); 
			
			//Error Handling
			try {	
				contact = new Contact(name,phone);
				list[count] = contact;
				count++;
				System.out.println("Contact Created Successfully");
			} catch (PhoneNumberException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Non-Numeric Character Found");
			}
		}
		
		//Displays the contents of the array
		System.out.println("Contacts:\n==========================");
		for(Contact item: list) {
			System.out.println(item);
			System.out.println("==========================");
		}
		
		scan.close();
	}

}
