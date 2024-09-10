//*****************************************************************
// CreateTriangle.java    Author: Christopher Moore
// Assignment 2           date: 6/1/2020
// problem 1b
//*****************************************************************

import java.util.Scanner;

public class CreateTriangle {
	//------------------------------------------------------------
	// Creates a triangle object using the trigangle.java class
	//------------------------------------------------------------
	public static void main(String[] args) {
		
		int x1,y1,x2,y2,x3,y3;
		Scanner scan = new Scanner(System.in);
		triangle tri = new triangle();
		
		System.out.print("Enter point one: ");
		x1 = scan.nextInt();
		y1 = scan.nextInt();
		tri.setP1(x1,y1);
		
		System.out.print("Enter point two: ");
		x2 = scan.nextInt();
		y2 = scan.nextInt();
		tri.setP2(x2,y2);
		
		System.out.print("Enter point three: ");
		x3 = scan.nextInt();
		y3 = scan.nextInt();
		tri.setP3(x3, y3);
		
		tri.side1();
		tri.side2();
		tri.side3();
		
		System.out.print(tri.toString());
		
		scan.close();
	}

}
