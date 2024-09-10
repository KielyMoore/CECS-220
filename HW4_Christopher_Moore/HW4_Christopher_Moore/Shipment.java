import java.util.Scanner;

//***********************************************************
// Package.java          Author: Christopher Moore
// Problem 1 C           Date: 7/2/2020
//
// Create a "Shipment" of package objects 
//***********************************************************
public class Shipment {

	//================================================================================
	// Create Package Objects and store them in an array
	// then display them back to the user
	//================================================================================
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Package[] packageList = new Package[50];
		int packageCount = 0;
		
		double weight;
		String streetAddress, city, state, zipCode, method; 
		
		//================================================================================
		// Main loop of the program, loop ends when the user stops making Package objects
		//================================================================================
		boolean loop;
		do
		{	
			//Enter weight
			System.out.print("Package Weight: ");
			weight = scan.nextDouble();
			scan.nextLine(); //scans rest of the line

			//Enter Shipping Method
			System.out.print("Shipping Method (Air, Ground, Sea): ");
			boolean shipCheck;
			do //Loops until the user enters a valid input
			{
				method = scan.nextLine();
				shipCheck = method.equalsIgnoreCase("air") || method.equalsIgnoreCase("ground") || method.equalsIgnoreCase("sea");
				if(!shipCheck) System.out.print("Invalid Shipping Method, Enter again: ");
			} while(!shipCheck);
			
			//Enter Destination Address
			System.out.print("Street Address: ");
			streetAddress = scan.nextLine();
			
			//Enter City
			System.out.print("City: ");
			city = scan.nextLine();
			
			//Enter State
			System.out.print("State: ");
			state = scan.nextLine();
			
			//Enter ZipCode
			System.out.print("5 digit Zip code: ");
			zipCode = scan.nextLine();
			
			//================================================================================
			// Create Package objects using inputed variables
			// Extends the packList ArrayList if necessary
			//================================================================================
			Address tempAdd = new Address(streetAddress, city, state, zipCode);
			Package tempPack = new Package(weight, method, tempAdd);
			if(packageCount == packageList.length)
			{
				Package[] tempList = new Package[packageList.length + 50];
				for(int i = 0; i < packageList.length; i++)
				{
					tempList[i] = packageList[i];
				}
				packageList = tempList;
			}
			packageList[packageCount] = tempPack;
			packageCount++;
		
			//Ask user if the want to continue
			System.out.print("Add another Package (y/n): ");
			String addAnother;
			addAnother =  scan.nextLine();
			if(addAnother.equalsIgnoreCase("y")) loop = true;
			else loop = false;
					
		} while(loop);
		
		scan.close();
		
		//================================================================================
		// Check for Applicable discounts and apply them
		//================================================================================
		for (int i=1; i < packageCount; i++)
		{
			if(packageList[i].getAddress().equals(packageList[i-1].getAddress()))
			{
				packageList[i].applyDiscount();
				packageList[i-1].applyDiscount();
			}
		}
		
		
		//================================================================================
		// Display the packageList to the user
		//================================================================================
		System.out.println("");
		for (int j = 0; j < packageCount; j++)
		{
			System.out.print(packageList[j]);
			System.out.println("----------------------------");
		}
		
	}
	

}
