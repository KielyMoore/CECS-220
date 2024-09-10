//****************************************************
// change.java       Author: Christopher Moore
// Assignment 1      Date: 5/31/2020         
// Problem 1 a        
//****************************************************

import java.util.Scanner;

public class change 
{
	//-------------------------------------------
	//	determines the change to be dispensed
	//  by a vending machine 	
	//-------------------------------------------
	public static void main(String[] args) 
	{
		int price;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter price of item: (from 25 cents to a dollar in 25 cent increments)");
		
		do
		{
			price = scan.nextInt();
		
		}while(!(price>=25 && price<=100 && price%5 == 0));
		
		
		int change = 100 - price;
		int quarters = change / 25;
		change -= 25*quarters;
		int dimes = change / 10;
		change -= 10*dimes;
		int nickels = change / 5;
	
		System.out.println("You bought an item for " + price + " cents and gave me a dollar.\nYour change is ");
		System.out.println(quarters + " quarters,");	
		System.out.println(dimes + " dimes,");
		System.out.println("and " + nickels + " nickel." );
		
		scan.close();
	}

}
