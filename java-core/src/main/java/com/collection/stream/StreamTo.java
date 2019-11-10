package com.collection.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamTo {

	static Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4, 5);

	public static void toList() {
		List<Integer> list = stream.collect(Collectors.toList());
	}

	public static void toArray() {
		Integer[] arr = stream.toArray(Integer[]::new);
	}

	public static void main(String[] args) {
		toList();
		toArray();
	}

}
