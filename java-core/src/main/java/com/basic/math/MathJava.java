package com.basic.math;

public class MathJava {

	// Convert `long` -> `int`
	public static void longToInt() {
		long longValue = 123l;
		int intValue = Math.toIntExact(longValue);
		System.out.println(intValue);
	}

	public static void main(String[] args) {
		longToInt();
	}

}
