package com.basic.charandstring;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ASCII {

	public static void usingStreamIterate() {
		Object[] array = Stream.iterate('a', i -> ++i) //
				.limit(26) //
				.toArray();
		System.out.println(Arrays.toString(array));
	}

	public static void usingIntStream() {
		int[] array = IntStream.rangeClosed('a', 'k') //
				.map(t -> (char) t) //
				.toArray();
		System.out.println(Arrays.toString(array));
	}

	public static void usingMapToObj() {
		Object[] arr = IntStream.rangeClosed('a', 'z') //
				.mapToObj(v -> (char) v) //
				.toArray();
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// usingStreamIterate();
		// usingIntStream();
		usingMapToObj();
	}
}
