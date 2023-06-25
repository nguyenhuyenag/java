package com.basic.charstring;

public class CharacterApi {

	public static void main(String[] args) {
		int codePoint1 = 6511; // Mã điểm mã Unicode cho ký tự 'A'
		int codePoint2 = 128514; // Mã điểm mã Unicode cho biểu tượng cười 😂

		int count1 = Character.charCount(codePoint1);
		int count2 = Character.charCount(codePoint2);

		System.out.println("charCount for codePoint1: " + count1); // Kết quả: 1
		System.out.println("charCount for codePoint2: " + count2); // Kết quả: 2
		
	}
	
}
