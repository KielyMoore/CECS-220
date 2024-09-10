import java.util.Scanner;
//***********************************************************
// Subscribers.java           Author: Christopher Moore
// Problem 1 C                Date: 7/19/2020
//
// User creates a list of Subscription objects
//***********************************************************
public class Subscribers {

	static NewsPaperSubscriber[] Subscriptions;
	static int count;
	static Scanner scan; 
	
	/*
	 * Allows user to create NewsPaperSubscriber objects then ends
	 * when the user specifies. 
	 * calls the addSubscription Method
	 * Displays the contents of the list of objects
	 */
	public static void main(String[] args) {
		
		Subscriptions = new NewsPaperSubscriber[50];
		count = 0;
		scan = new Scanner(System.in);
		
		//loops until user ends program
		boolean menu = true;
		while(menu) {
			System.out.print("Create New Subscription (y/n): ");
			do
			{
				String input = scan.next();
				if(input.equalsIgnoreCase("y")) {
					addSubscription();
					break;
				}
				else if (input.equalsIgnoreCase("n")) {
					menu = false; 
					break;
				}
				else System.out.print("Invalid Input. Enter Again: ");
			} while(true);
		}
		
		//display contents of the array
		System.out.println("\nSubscriptions:\n=========================================");
		for(int item = 0; item < count; item++){
			System.out.println(Subscriptions[item]);
			System.out.println("=========================================");
		}
		scan.close();
	}
	
	/*
	 * Add a NewsPaperSubscriber object specified by the user 
	 * to the Subscriptions NewspaperSubscriber object array
	 * creates child objects of NewsPaperSubscriber class based on user specification
	 * Does not allow user to assign an Address to more than one subscription type
	 */
	static void addSubscription() {
	
		//Extend the array if needed
		if(count == Subscriptions.length) {
			NewsPaperSubscriber[] temp = new NewsPaperSubscriber[Subscriptions.length + 50];
			for(int ind = 0; ind < Subscriptions.length; ind++) 
				temp[ind] = Subscriptions[ind];
			Subscriptions = temp;
		}
		
		System.out.println("Choose Service Type: \n1. Seven Day\n2. Weekday\n3. Weekend");
		int type;
		String Address;
		
		
		do { //Accepts user input until a valid type is chosen
			type = scan.nextInt();
		} while (type < 1 && type > 3);
		scan.nextLine();
		
		System.out.print("Enter Street Address: ");
		Address = scan.nextLine();
		
		//Creates Object of Class specified by user
		switch(type) {
		case 1: Subscriptions[count] = new SevenDaySubscriber(Address); break;
		case 2: Subscriptions[count] = new WeekdaySubscriber(Address); break;
		case 3: Subscriptions[count] = new WeekendSubscriber(Address); break;
		}
		
		//iterates through the items of the array to see if any of them
		//share the same address as the current object
		//changes address if Address was already used
		boolean UsedAddress = false;
		do{
			for(int i = 0; i < count; i++) {
				if(Subscriptions[count].equals(Subscriptions[i])) {
					System.out.println("Address already has a subscription.\nChange Address: ");
					Address = scan.nextLine();
					Subscriptions[count].setAddress(Address);
					UsedAddress = true;
					break;
				}
				UsedAddress = false;
			}
		} while(UsedAddress);
		count++;
	}
}
