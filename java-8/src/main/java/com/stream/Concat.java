package com.stream;

import java.util.stream.Stream;

// Nối stream
public class Concat {

	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1, 2, 3, 4);
		Stream<String> s2 = Stream.of("a", "b", "c", "d");
		Stream.concat(s1, s2).forEach(t -> System.out.println(t));
	}

}
