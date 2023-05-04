package com.stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

// list.stream() -> Stream ko thể dùng lại nên phải khởi tạo lại dùng
public class StreamMatch {

	@SuppressWarnings("unlikely-arg-type")
	static boolean check(int[] arr, int value) {
		// this doesn't work for arrays of primitives (see the comments).
		return Arrays.asList(arr).contains(value);
	}

	/**
	 * anyMatch -> TRUE nếu có ít nhất 1 phần tử thỏa điều kiện
	 */
	public static boolean anyMatch(int[] arr, int key) {
		return IntStream.of(arr).anyMatch(x -> x == key);
	}

	/**
	 * allMatch -> TRUE nếu tất cả các phần tử thỏa điều kiện
	 */
	public static boolean allMatch(int[] arr, int key) {
		return IntStream.of(arr).allMatch(x -> x == key);
	}

	/**
	 * noneMatch -> TRUE nếu tất cả các phần tử không thỏa điều kiện
	 */
	public static boolean noneMatch(int[] arr, int key) {
		return IntStream.of(arr).noneMatch(x -> x % key == 0);
	}

	public static boolean findString(String[] array, String key) {
		Predicate<String> predicate = s -> s.equals("key");
		return Arrays.stream(array).anyMatch(predicate);
	}

	public static void main(String[] args) {
		String[] values = { "AB", "BC", "CD", "AE" };
		System.out.println(findString(values, "AB"));

		int[] arr = { 4, 4, 4, 4 };

		System.out.println(anyMatch(arr, 3));
		System.out.println(allMatch(arr, 4));
		System.out.println(noneMatch(arr, 4));

	}

}
