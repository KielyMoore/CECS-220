//*****************************************************************
// triangle.java    Author: Christopher Moore
// Assignment 2     date: 6/1/2020
// problem 1a
//*****************************************************************

import java.text.DecimalFormat;

public class triangle {
//----------------------------------------------------------------
// class represents a triangle object, with properties verticies
// side lengths, and area.
//----------------------------------------------------------------	
	
	private int x1,y1,x2,y2,x3,y3;
	private double side1,side2,side3;
	DecimalFormat fmt = new DecimalFormat("#.##");
	
	//constructor
	public triangle() { 
		x1 = y1 = 0;
		x2 = y2 = 0;
		x3 = y3 = 0;
		side1 = side2 = side3 = 0;
	}
	
	//calculate the area of the triangle
	public double area() {
		double perimeter = side1+side2+side3;
		double H = perimeter/2;
		double area =  Math.sqrt(H*(H-side1)*(H-side2)*(H-side3));
		return area;
	}
	
	//Mutators
	public void setP1(int x, int y) {
		x1 = x; y1 = y;
	}
	public void setP2(int x, int y) {
		x2 = x; y2 = y;
	}
	public void setP3(int x, int y) {
		x3 = x; y3 = y;
	}
	
	// Mutator/accessors
	public double side1() {
		side1 = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		return side1;
	}
	public double side2() {
		side2 = Math.sqrt(Math.pow(x3-x1, 2)+Math.pow(y3-y1, 2));
		return side2;
	}
	public double side3() {	
		side3 = Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y2-y1, 2));
		return side3;
	}
	
	//Accessors
	public int getx1() { 
		return x1;
	}
	public int gety1() { 
		return y1;
	}
	public int getx2() { 
		return x2;
	}
	public int gety2() { 
		return y2;
	}
	public int getx3() { 
		return x3;
	}
	public int gety3() { 
		return y3;
	}
	
	public String toString() {
		String r1 = "Vertices: ("+x1+","+y1+") ("+x2+","+y2+") ("+x3+","+y3+")\n"; 
		String r2 = "Side lenghts: " + fmt.format(side1) + ", " + fmt.format(side2) +", "+ fmt.format(side3) + "\n";
		String r3 = "Perimeter: " + fmt.format(side1+side2+side3) + "\n";
		String r4 = "Area: " + fmt.format(this.area()) + "\n"; 
		String result = r1 + r2 + r3 + r4;
		return result;
	}
	
}
