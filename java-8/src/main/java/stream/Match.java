package stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Match {

	@SuppressWarnings("unlikely-arg-type")
	static boolean check(int[] arr, int value) {
		// this doesn't work for arrays of primitives (see the comments).
		return Arrays.asList(arr).contains(value);
	}

	static boolean findString(String[] array, String key) {
		Predicate<String> predicate = s -> s.equals("key");
		return Arrays.stream(array).anyMatch(predicate);
	}

	static boolean findInt(int[] arr, int key) {
		return IntStream.of(arr).anyMatch(x -> x == key);
	}

	static boolean allMatchs(int[] arr, int key) {
		return IntStream.of(arr).allMatch(x -> x == key);
	}

	public static void main(String[] args) {

		String[] values = { "AB", "BC", "CD", "AE" };
		System.out.println(findString(values, "AB"));

		int[] arr = { 4, 4, 4, 4 };
		System.out.println(findInt(arr, 3));

		System.out.println(allMatchs(arr, 4));

	}

}
