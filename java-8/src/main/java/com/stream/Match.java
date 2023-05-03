package com.stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

// list.stream() -> Stream ko thể dùng lại nên phải khởi tạo lại dùng
public class Match {

	@SuppressWarnings("unlikely-arg-type")
	static boolean check(int[] arr, int value) {
		// this doesn't work for arrays of primitives (see the comments).
		return Arrays.asList(arr).contains(value);
	}

	public static boolean findString(String[] array, String key) {
		Predicate<String> predicate = s -> s.equals("key");
		return Arrays.stream(array).anyMatch(predicate);
	}

	/**
	 * Stream#anyMatch trả về TRUE nếu có một phần tử nào đó trong stream thỏa mãn
	 * điều kiện được đặt ra. Ngược lại Stream#anyMatch trả về FALSE nếu stream rỗng
	 * hoặc không có bất kỳ phần tử nào thỏa điều kiện
	 */
	public static boolean anyMatch(int[] arr, int key) {
		return IntStream.of(arr).anyMatch(x -> x == key);
	}

	/**
	 * Stream#allMatch trả về TRUE nếu tất cả các phần tử trong stream đều thỏa mãn
	 * điều kiện cho trước, ngược lại FALSE.
	 */
	public static boolean allMatch(int[] arr, int key) {
		return IntStream.of(arr).allMatch(x -> x == key);
	}

	/**
	 * Ngược lại với Stream#allMatch, Stream#noneMatch trả về TRUE nếu tất cả các
	 * phần tử trong stream đều không thỏa điều kiện được đặt ra.
	 */
	public static boolean noneMatch(int[] arr, int key) {
		return IntStream.of(arr).noneMatch(x -> x % key == 0);
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
