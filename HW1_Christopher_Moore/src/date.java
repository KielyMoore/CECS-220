//****************************************************
// date.java         Author: Christopher Moore
// Assignment 1      Date: 5/31/2020         
// Problem 1 b        
//****************************************************

import java.util.Scanner;

public class date 
{
	
	//-------------------------------------------
	//  Changes dates from American format
	//  to European format
	//-------------------------------------------
	
	public static void main(String[] args) 
	{
		
		String date, formated;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter date in American format (MM/DD/YYYY): ");
		date = scan.next();
		
		String month = date.substring(0,2);
		String day = date.substring(3,5);
		String year = date.substring(6,10);
		
		formated = day + "." + month + "." + year;
		System.out.println("The European format of " + date + " is: " + formated);
		
		scan.close();
	}

}
