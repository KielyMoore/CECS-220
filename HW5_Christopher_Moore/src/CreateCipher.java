import java.util.Scanner;

//***********************************************************
// CreateCipher.java          Author: Christopher Moore
// Problem 1 C                Date: 7/12/2020
//
// Allows a user to Encode and Decode subsitution Ciphers
//***********************************************************
public class CreateCipher {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {		
		
		boolean menu = true;
		do {
			System.out.println("Select an Action");
			System.out.println("1. Encrypt a Message");
			System.out.println("2. Decrypt a Message");
			System.out.println("3. Quit");
			
			int input;
			while(true) {
				input = scan.nextInt();
				if (input >= 1 && input <= 3) break;
				else System.out.println("Invalid Input\nEnter Again: ");
			}
			
			switch(input) {
			case 1: encrypt(); break;
			case 2: decrypt(); break;
			case 3: menu = false; break;
			default: break;
			}
			
		} while(menu);
		
		System.out.println("Goodbye");
	}


	private static void encrypt() {
		System.out.println("Enter number of shifts: ");
		int shift = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter plain text: ");
		String plaintext = scan.nextLine(); 
		
		SubsitutionCipher cipher = new SubsitutionCipher(plaintext,shift);
		System.out.println("Cypher Text: " + cipher.Encode());
	}
	
	private static void decrypt() {
		System.out.println("Enter number of shifts: ");
		int shift = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter plain text: ");
		String ciphertext = scan.nextLine(); 
		
		SubsitutionCipher cipher = new SubsitutionCipher();
		cipher.setCipher(ciphertext);
		cipher.setShift(shift);
		System.out.println("Plain Text: " + cipher.Decode());
	}
}
