package com.basic.charstring;

public class CharacterApi {

	public static void main(String[] args) {
		// Check lower case
		System.out.println(Character.isLowerCase('a'));
		// Check upper case
		System.out.println(Character.isUpperCase('A'));
		// Check digit
		System.out.println(Character.isDigit('1'));
		char ch3 = 'あ'; // Chữ cái tiếng Nhật Hiragana
		System.out.println(Character.isLetter(ch3)); 	 // Determines if the specified character is a letter 
		System.out.println(Character.isAlphabetic(ch3)); // Determines if the specified character (Unicode code point) is alphabetic 
	}
	
}
