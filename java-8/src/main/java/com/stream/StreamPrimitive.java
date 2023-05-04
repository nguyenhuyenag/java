package com.stream;

import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class StreamPrimitive {

	public static void createIntStream() {
		IntStream intRange = IntStream.range(1, 5);
		IntStream intStream = IntStream.of(new int[] { 1, 2, 3, 4, 5 });
	}

	// Convert IntStream -> int[]
	public static void fromArray(int[] arr) {
		int[] array = IntStream.range(1, 5).toArray();
	}

}
