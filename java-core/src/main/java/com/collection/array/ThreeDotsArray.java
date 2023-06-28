package com.collection.array;

/**
 * https://stackoverflow.com/questions/3158730/java-3-dots-in-parameters
 *
 * ArbitraryNumberArguments
 */
public class ThreeDotsArray {

	public static void todo(int... args) {
		for (int val : args) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		todo(0);
		todo(1, 2);
		todo(3, 4, 5, 6);
		todo(7, 8, 9, 0);
	}

}
