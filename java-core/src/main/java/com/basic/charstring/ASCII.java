package com.basic.charstring;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ASCII {

	public static Object[] usingStreamIterate() {
		return Stream.iterate('a', c -> ++c) //
				.limit(26) //
				.toArray();
	}

	public static Object[] usingMapToObj() {
		return IntStream.rangeClosed('a', 'z') //
				.mapToObj(t -> (char) t) //
				.toArray();
	}

	public static int[] usingIntStream() {
		return IntStream.rangeClosed('a', 'k') //
				.map(t -> (char) t) //
				.toArray();
	}

	public static void main(String[] args) {
		// usingStreamIterate();
		// usingIntStream();
		usingMapToObj();
	}
}
