//***********************************************************
// Address.java          Author: Christopher Moore
// Problem 1 A           Date: 7/1/2020
//
// Class represents an address
//***********************************************************
public class Address {
	
	private String streetAddress, city, state, zipCode; 
	
	//============================================================
	// Creates object and defines instance variables
	//============================================================
	public Address(String Add, String Cty, String Stt, String Zpc) 
	{
		this.streetAddress = Add;
		this.city = Cty;
		this.state = Stt;
		this.zipCode = Zpc;
	}

	//===========================================================
	// Method for comparing two objects of address class
	// returns true if the zipCode variable are equal
	//===========================================================
	public boolean equals(Address address)
	{
		if(this.zipCode.equals(address.zipCode))
			return true;
		else return false;
	}
	
	//==========================================================
	// return a formatted string of the objects variables
	//==========================================================
	public String toString()
	{
		String result = "Address: " + this.streetAddress + "\n" + this.city + ", " + this.state + " " + this.zipCode;
		return result;
	}
}
