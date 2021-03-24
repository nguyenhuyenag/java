package com.collection.array;

/**
 * https://stackoverflow.com/questions/3158730/java-3-dots-in-parameters
 *
 */
public class ArbitraryNumberArguments {

	public static void X(int... args) {
		for (int val : args) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		X(0);
		X(1, 2);
		X(3, 4, 5, 6);
		X(7, 8, 9, 0);
	}

}
