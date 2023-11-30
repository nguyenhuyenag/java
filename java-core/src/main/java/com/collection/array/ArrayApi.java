package com.collection.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayApi {
	
	private static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(Arrays::deepToString) //
				.collect(Collectors.joining(" + "));
	}

	// So sánh mảng
	public static void compareArray() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int[] arr3 = { 1, 2, 3, 4 };
		System.out.println("arr1 == arr2 ? => " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 == arr3 ? => " + Arrays.equals(arr1, arr3));
	}

	// Sao chép mảng
	public static void copyArray() {
		Integer[] arr = { 1, 2, 3, 4, 5, 2, 4, 1, 0, 5, 5 };

		// Use Arrays.copyOf()
		Integer[] copyOf = Arrays.copyOf(arr, 5);
		Integer[] copyOfRange = Arrays.copyOfRange(arr, 0, 3);
		System.out.println(Arrays.toString(copyOf));
		System.out.println(Arrays.toString(copyOfRange));

		// Use Object.clone()
		Integer[] copyArr2 = arr.clone();
		System.out.println(Arrays.toString(copyArr2));

		// Use Java 8 stream
		Integer[] copiedArray = Arrays.stream(arr).toArray(Integer[]::new);
		System.out.println(Arrays.toString(copiedArray));
	}

	// Gộp mảng
	public static void joinArray() {
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = new String[] { "d", "e", "f" };
		String[] join = ArrayUtils.addAll(arr1, arr2);
		System.out.println(print(arr1, arr2) + " = " + print(join));
	}

	public static void arraysApi() {
		int[] arr = new int[5]; // {0, 0, 0, 0, 0}
		
		// fill
		Arrays.fill(arr, -1);
		System.out.println("Fill: " + Arrays.toString(arr) + "\n");

		// setAll, parallelSetAll -> Lặp qua index của mảng
		int[] arr2 = { 1, 0, 2, 2 };
		Arrays.setAll(arr2, index -> arr2[index] * arr2[index]);
		System.out.println("SetAll: " + Arrays.toString(arr2) + "\n");

		// parallelPrefix
		int[] arr3 = { -1, 4, 0, 3 };
		System.out.println("ParallelPrefix");
		System.out.println("Start: " + Arrays.toString(arr3));
		Arrays.parallelPrefix(arr3, (left, right) -> {
			System.out.println("left=" + left + ", right=" + right + " -> " + Arrays.toString(arr3));
			return left + right;
		});
		System.out.println("End: " + Arrays.toString(arr3));
		
		// mismatch -> Tìm vị trí đầu tiên mà hai mảng không khớp (khác nhau)
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {1, 2, 3, 6, 5};
		int mismatchIndex = Arrays.mismatch(array1, array2);
		System.out.println(mismatchIndex); // Output: 3
	}

	public static void main(String[] args) {
		arraysApi();
		// joinArray();
		// copyArray();
		// compareArray();
	}
}
