package com;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int codePoint = 128512; // Mã điểm mã Unicode cho biểu tượng cười "😀"

		char[] chars = Character.toChars(codePoint);

		System.out.println("Character array length: " + chars.length); // Kết quả: 2
		System.out.println("Character 1: " + chars[0]); // Kết quả: '\uD83D'
		System.out.println("Character 2: " + chars[1]); // Kết quả: '\uDE00'

	}

}
