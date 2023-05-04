package com.preview;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamPrimitive {

	// filter odd number
	static void fromArray(int[] arr) {
		arr = IntStream.of(arr) //
				.filter(t -> t % 2 != 0) //
				.toArray();
		System.out.println(Arrays.toString(arr));
	}

	// Tính trung bình của tổng: 0 + 1 + 2 + 3 + 4 + 5
	static void fromRange() {
		double value = IntStream.range(0, 5).average().getAsDouble();
		System.out.println("Average: " + value);
		// Tương tự cho LongStream, LongStream
	}

	public static void main(String[] args) {
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// fromArray(arr);
		// fromRange();
	}

}
