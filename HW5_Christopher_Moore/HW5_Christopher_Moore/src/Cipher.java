//***********************************************************
// Cipher.java           Author: Christopher Moore
// Problem 1 A           Date: 7/11/2020
//
// Abrstract Class that represents a Cipher
//***********************************************************
public abstract class Cipher {

	protected String PlainText, CipherText;
	
	public Cipher(String text) {
		PlainText = text;
		CipherText = "";	
	}
	
	public String getPlain() {
		return PlainText;
	}
	
	public String getCipher() {
		return CipherText;
	}
	
	public void setPlain(String text) {
		PlainText = text;
	}
	
	public void setCipher(String text) {
		CipherText = text;
	}
	
	public abstract String Encode();
	public abstract String Decode();
}
