//***********************************************************
// NewsPaperSubscriber.java          Author: Christopher Moore
// Problem 1 A                 		 Date: 7/19/2020
//
// Abstract class for news paper subscriptions
//***********************************************************
public abstract class NewsPaperSubscriber {
	
	protected String StreetAddress;
	protected double SubscriptionRate;
	
	/*
	 * Constructor Accepting one Argument for Street Address
	 * Initializes SubscriptionRate to 0;
	 */
	public NewsPaperSubscriber(String StreetAddress) {
		setAddress(StreetAddress);
		SubscriptionRate = 0;
	}
	
	/*
	 * Method for changing the StreetAddress variable
	 */
	public void setAddress(String StreetAddress){
		this.StreetAddress = StreetAddress;
	}
	
	/*
	 * Method for Accessing the value of the StreetAddress variable
	 */
	public String getAddress() {
		return StreetAddress;
	}
	
	/*
	 * Abstract Method to set the value of the SubscriptionRate variable
	 * to be overwritten by child classes
	 */
	public abstract void setRate();
	
	/*
	 * Method for Accessing the value of the SubscriptionRate variable
	 */
	public double getRate() {
		return SubscriptionRate;
	}
	
	
	/*
	 * Method for comparing two NewsPaperSubscriber Objects
	 * NewsPaperSubscriber objects are equal if their StreetAddress Strings are Equal
	 * returns true Strings are equal
	 */
	public boolean equals(NewsPaperSubscriber Subscriber) {
		if(this.StreetAddress.equalsIgnoreCase(Subscriber.StreetAddress))
			return true;
		else
			return false;
	}
	
}
