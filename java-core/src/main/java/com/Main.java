package com;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String sourceString = "Hello, World!";
		char[] destinationArray = new char[5];

		// Sao chép phần của chuỗi vào mảng ký tự
		sourceString.getChars(0, 5, destinationArray, 0);

		// In ra mảng ký tự đích
		System.out.println("Destination Array: " + new String(destinationArray));
	}

}
