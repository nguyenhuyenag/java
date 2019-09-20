package stream.init;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamInit {

	static Integer[] arr = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void useStreamOf() {
		Stream<Integer> stream = Stream.of(arr);
		stream.forEach(System.out::println);
	}

	public static void useArraysStream() {
		Stream<Integer> stream = Arrays.stream(arr);
		stream.forEach(System.out::println);
	}

	public static void useCollection() {
		Stream<Integer> stream = Arrays.asList(arr).stream();
		stream.forEach(System.out::println);
	}

	public static void useStreamGenerate() {
		Stream<String> stream = Stream.generate(() -> "Java").limit(3);
		stream.forEach(System.out::println);
	}

	public static void useStreamIterateLimit() {
		Stream<Integer> stream = Stream.iterate(0, t -> ++t) //
				.limit(10);
		stream.forEach(System.out::println);
	}

	public static void main(String[] args) {
		// useStreamOf();
		// useArraysStream();
		// useCollection();
		// useStreamGenerate();
		useStreamIterateLimit();
	}

}
