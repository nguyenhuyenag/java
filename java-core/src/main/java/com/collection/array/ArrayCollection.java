package com.collection.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayCollection {

	/**
	 * So sánh mảng
	 */
	public static void compareArray() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int[] arr3 = { 1, 2, 3, 4 };
		System.out.println("arr1 == arr2 ? => " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 == arr3 ? => " + Arrays.equals(arr1, arr3));
	}

	/**
	 * Sao chép mảng
	 */
	public static void copyArray() {
		String[] arr = { "1", "2", "3", "4", "5" };
		// Use Arrays.copyOf()
		String[] copyArr1 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(copyArr1));
		// Use Object.clone()
		String[] copyArr2 = arr.clone();
		System.out.println(Arrays.toString(copyArr2));
		// Use Java 8 stream
		String[] copiedArray = Arrays.stream(arr).toArray(String[]::new);
		System.out.println(Arrays.toString(copiedArray));
	}

	private static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(t -> Arrays.deepToString(t)) //
				.collect(Collectors.joining(" + "));
	}

	/**
	 * Gộp mảng
	 */
	public static void joinArray() {
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = new String[] { "d", "e", "f" };
		String[] join = ArrayUtils.addAll(arr1, arr2);
		System.out.println(print(arr1, arr2) + " = " + print(join));
	}

	public static void main(String[] args) {
		// compareArray();
		// copyArray();
		joinArray();
	}
}
