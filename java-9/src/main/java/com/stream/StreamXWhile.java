package com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamXWhile {

	public static void takeWhile1() {
		Stream.iterate("", s -> s + "s") //
				.takeWhile(s -> s.length() < 10) //
				.forEach(t -> System.out.println(t));
	}

	public static void takeWhile2() {
		Stream<Integer> stream = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
		// apply dropWhile to drop all the numbers matches passed predicate
		List<Integer> list = stream.takeWhile(number -> (number / 4 == 1)).collect(Collectors.toList());
		System.out.println(list);
	}

	public static void dropWhile1() {
		Stream<Integer> stream = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> list = stream.dropWhile(number -> (number / 4 == 1)).collect(Collectors.toList());
		System.out.println(list);
	}

	public static void dropWhile2() {
		Stream<String> stream = Stream.of("aman", "amar", "suraj", "suvam", "Zahafuj");
		List<String> list = stream.dropWhile(name -> name.startsWith("a")).collect(Collectors.toList());
		System.out.println(list);
	}

	public static void main(String[] args) {
		takeWhile2();
		// dropWhile1();
		// dropWhile2();
	}

}
