//***********************************************************
// WeekendSubscriber.java          Author: Christopher Moore
// Problem 1 B                     Date: 7/19/2020
//
// Represents a Weekend subscription, Inherits NewsPaperSubscriber Class
//***********************************************************
public class WeekendSubscriber extends NewsPaperSubscriber {

	/*
	 * Constructor taking one argument for Inherited StreetAddress Variable
	 * Calls parent constructor
	 * Calls the setRate method
	 */
	public WeekendSubscriber(String StreetAddress) {
		super(StreetAddress);
		setRate();
	}

	/*
	 * Sets the SubscriptionRate for a WeekendSubscriber
	 * SubscriptionRate Inherited from Parent Class
	 */
	public void setRate() {
		this.SubscriptionRate = 4.5;
	}

	/*
	 * formats object for when called as a string
	 */
	public String toString() {
		return "Address: " + StreetAddress 
				+ "\nRate: " + SubscriptionRate 
				+ "\ntype: Weekend Service";
	}
}
