package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamPrimitive {

	// int[] -> IntStream
	public static void convert1() {
		IntStream intRange = IntStream.range(1, 5);
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
	}

	// IntStream -> int[]
	public static void convert2() {
		// [1, 2, 3, 4]
		int[] arr1 = IntStream.range(1, 5).toArray();
		System.out.println(Arrays.toString(arr1));

		// [1, 2, 3, 4, 5]
		int[] arr2 = IntStream.rangeClosed(1, 5).toArray();
		System.out.println(Arrays.toString(arr2));
	}

	// String -> IntStream
	public static void convert3() {
		IntStream chars = "abcd".chars();
	}

	// String -> Stream<Character>
	public static void convert4() {
		String input = "abcd";
		Stream<Character> mapToObj = input.chars().mapToObj(c -> (char) c);
	}

	public void streamFromFile() {
		try (Stream<String> lines = Files.lines(Paths.get(""))) {
			lines.forEach(System.out::println);
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	public static void main(String[] args) {
		convert2();
	}

}
