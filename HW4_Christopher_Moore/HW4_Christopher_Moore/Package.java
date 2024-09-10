import java.text.DecimalFormat;
import java.text.NumberFormat;

//******************************************************************************
// Package.java          Author: Christopher Moore
// Problem 1 B           Date: 7/1/2020
//
// Class representation of a Package that references the Address class
//*****************************************************************************
public class Package {
	
	static private enum Shipping {Air, Ground, Sea};
	static private double[][] baseCosts =  {{4.00 , 1.80, 0.55},
											{6.00, 2.80, 1.50},
											{9.00, 4.00, 2.00}};
	
	private double TrackingID, Weight, Cost;
	private boolean Discount;
	private Shipping shipMethod;
	private Address Destination;
	
	//===================================================================================
	// Constructor for Package object
	// Accepts inputs for Weight, shipping Method, and Destination
	// Discount defaults to false, Tracking ID is assigned a random 6 digit number
	// Call the setShipMethod method where cost is also calculated
	//===================================================================================
	public Package(double weight, String method, Address address)
	{
		TrackingID = Math.random() * 999999;
		Weight = weight;
		Discount = false;
		setShipMethod(method);
		Destination = address;
	}
	
	//================================================================================
	// calculate the cost of the package based on Weight and shipMethod
	// uses the baseCost ArrayList
	//================================================================================
	private void calculateCost()
	{
		int weightIndex = 0, shippingIndex = 0;
		
		if(Weight < 9) weightIndex = 0;
		else if (Weight < 17) weightIndex = 1;
		else weightIndex = 2;
		
		if(shipMethod == Shipping.Air) shippingIndex = 0;
		else if (shipMethod == Shipping.Ground) shippingIndex = 1;
		else if (shipMethod == Shipping.Sea) shippingIndex = 2;
		
		Cost = baseCosts[weightIndex][shippingIndex] * (Discount ? 0.9 : 1);
	}
	
	//================================================================================
	// changes the value of Discount
	// calls the calculateCost method
	//================================================================================
	public void applyDiscount() 
	{
		if(!Discount) 
		{
			Discount = true;
			calculateCost();
		}
	}
	
	//================================================================================
	// Creates a string to represent the object
	//================================================================================
	public String toString()
	{
		NumberFormat cur = NumberFormat.getCurrencyInstance();
		DecimalFormat dec = new DecimalFormat("#.##");
		DecimalFormat ID = new DecimalFormat("#######");
		
		String result = "Package info:\nWeight: " + dec.format(Weight) + " ounces\nShipping Method: "
						 + shipMethod + "\nCost: " + cur.format(Cost) + "\nApplied Discount: "
						 + (Discount ? "Yes" : "No") + "\nTracking ID: " + ID.format(TrackingID)
						 + "\n" + Destination + "\n";
		return result; 
	}
	
	
	//================================================================================
	// Weight accessor and mutator
	// calls the calculateCost Method
	//================================================================================
	public void setWeight(double weight) {
		Weight = weight;
	    calculateCost();
	}
	
	public double getWeight()
	{
		return Weight;
	}
	
	//================================================================================
	// shipMethod accessor and mutator
	// calls the calculateCost Method
	//================================================================================
	public void setShipMethod(String method)
	{
		if(method.equalsIgnoreCase("air")) shipMethod = Shipping.Air;
		else if(method.equalsIgnoreCase("ground")) shipMethod = Shipping.Ground;
		else if(method.equalsIgnoreCase("sea")) shipMethod = Shipping.Sea;
	    calculateCost();
	}
	public String getShipMethod()
	{
		return shipMethod + "";
	}
	
	//================================================================================
	// Address accessor and Mutator
	//================================================================================
	public void setAddress(Address address)
	{
		Destination = address;
	}
	
	public Address getAddress()
	{
		return Destination;
	}
}
