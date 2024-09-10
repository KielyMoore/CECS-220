//***********************************************************
// WeekdaySubscriber.java          Author: Christopher Moore
// Problem 1 B                     Date: 7/19/2020
//
// Represents a Weekday subscription, Inherits NewsPaperSubscriber Class
//***********************************************************
public class WeekdaySubscriber extends NewsPaperSubscriber {

	/*
	 * Constructor taking one argument for Inherited StreetAddress Variable
	 * Calls parent constructor
	 * Calls the setRate method
	 */
	public WeekdaySubscriber(String StreetAddress) {
		super(StreetAddress);
		setRate();
	}

	/*
	 * Sets the SubscriptionRate for a WeekdaySubscriber
	 * SubscriptionRate Inherited from Parent Class
	 */
	public void setRate() {
		this.SubscriptionRate = 7.5;
	}

	/*
	 * formats object for when called as a string
	 */
	public String toString() {
		return "Address: " + StreetAddress 
				+ "\nRate: " + SubscriptionRate 
				+ "\ntype: Weekday Service";
	}
}
