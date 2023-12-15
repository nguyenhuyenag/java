package com.basic.charstring;

public class CharacterApi {

	public static void main(String[] args) {
		// Char như số nguyên
		char c = '9';
		System.out.println("As Integer: " + (c - '5'));
		System.out.println("As Integer: " + (Character.getNumericValue(c) - 5));

		// Check lower case
		System.out.println("IsLowerCase: " + Character.isLowerCase('a'));

		// Check upper case
		System.out.println("IsUpperCase: " + Character.isUpperCase('A'));

		// Check digit
		System.out.println("IsDigit: " + Character.isDigit('1'));
		
		char ch3 = 'あ'; // Chữ cái tiếng Nhật Hiragana
		// Determines if the specified character is a letter
		System.out.println("IsLetter: " + Character.isLetter(ch3));

		// Determines if the specified character (Unicode code point)
		System.out.println("IsAlphabetic: " + Character.isAlphabetic(ch3));

		/*- Chuyển một số nguyên thành một ký tự tương ứng dựa trên một hệ số cơ số
		 * 
		 * 	   digit: Số nguyên cần chuyển đổi thành ký tự. 
		 * 
		 * 	   radix: Hệ cơ số, có giá trị từ 2 đến 36.
		 */
		System.out.println("ForDigit: " + Character.forDigit(10, 16));
	}

}
