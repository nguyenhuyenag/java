package com.basic.charstring;

public class CharacterApi {

	public static void main(String[] args) {
		// Check lower case
		System.out.println("IsLowerCase: " + Character.isLowerCase('a'));

		// Check upper case
		System.out.println("IsUpperCase: " + Character.isUpperCase('A'));

		// Check digit
		System.out.println("IsDigit: " + Character.isDigit('1'));
		char ch3 = 'あ'; // Chữ cái tiếng Nhật Hiragana
		System.out.println("IsLetter: " + Character.isLetter(ch3)); // Determines if the specified character is a letter
		System.out.println("IsAlphabetic: " + Character.isAlphabetic(ch3)); // Determines if the specified character
																			// (Unicode code point)

		/*-
		 * digit: Số nguyên cần chuyển đổi thành ký tự. 
		 * radix: Hệ cơ số, có giá trị từ 2 đến 36.
		 */
		System.out.println("ForDigit: " + Character.forDigit(10, 16));
	}

}
