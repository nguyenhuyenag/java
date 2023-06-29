package com.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamPrimitive {

	// int[] -> IntStream
	public static void convert1() {
		IntStream intRange = IntStream.range(1, 5);
		IntStream intStream = IntStream.of(new int[] { 1, 2, 3, 4, 5 });
	}

	// IntStream -> int[]
	public static void convert2() {
		int[] array = IntStream.range(1, 5).toArray();
	}

	// String -> IntStream
	public static void convert3() {
		String input = "abcd";
		IntStream chars = input.chars();
	}

	// String -> Stream<Character>
	public static void convert4() {
		String input = "abcd";
		Stream<Character> mapToObj = input.chars().mapToObj(c -> (char) c);
	}

}
