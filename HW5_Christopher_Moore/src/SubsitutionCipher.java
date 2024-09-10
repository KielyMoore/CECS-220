//***********************************************************
// SubsitutionCipher.java          Author: Christopher Moore
// Problem B                       Date: 7/11/2020
//
// Inherits the Abstract Class Cipher
//***********************************************************
public class SubsitutionCipher extends Cipher{

	private int shift;
	
	public SubsitutionCipher(){
		super("");
		shift = 0;	
	}
	
	public SubsitutionCipher(String text, int num) {
		super(text);
		shift = num;
	}

	public String Encode() {
		char[] arrPlain = PlainText.toCharArray();
		char[] arrCipher = new char[arrPlain.length];
		for(int i = 0; i < PlainText.length(); i++) {
			arrCipher[i] = Shift(arrPlain[i], shift);
		}
		String encode = new String(arrCipher);
		CipherText = encode;
		return encode;
	}

	public String Decode() {
		char[] arrCipher = CipherText.toCharArray();
		char[] arrPlain = new char[arrCipher.length];
		for(int i = 0; i < CipherText.length(); i++) {
			arrPlain[i] = Shift(arrCipher[i], -shift);
		}
		String decode = new String(arrPlain);
		PlainText = decode;
		return decode;
	}

	//Shift a single letter
	private char Shift(char c, int i) {
		//Capital Letters
		if((int)c <= 90 && (int)c >= 65)
		{
			if((int)c + i < 65) {
				return (char)(91 -(65 - ((int)c + i)));
			}
			else if((int)c + i > 90) {
				return (char)(64 + (((int)c + i) - 90));
			}
			else return (char)((int)c + i);
		}
		//Lower Case letters
		else if((int)c <= 122 && (int)c >= 97)
		{
			if((int)c + i < 97) {
				return (char)(123 -(97 - ((int)c + i)));
			}
			else if((int)c + i > 122) {
				return (char)(96 + (((int)c + i) - 122));
			}
			else return (char)((int)c + i);
		}
		//return if not letter character
		else return c;
	}
	
	public int getShift() {
		return shift;
	}
	
	public void setShift(int num){
		shift = num;
	}
}

