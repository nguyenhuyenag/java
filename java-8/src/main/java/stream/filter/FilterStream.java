package stream.filter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterStream {

	/**
	 * Stream filter() giúp loại bỏ các phần tử dựa trên các tiêu chí nhất định
	 */
	public static void main(String[] args) {

		Stream.iterate(1, count -> count + 1) //
				.filter(number -> number % 3 == 0) // chia het cho 3
				.limit(6) //
				.forEach(System.out::println);

		IntStream.range(0, 10) //
				.filter(number -> number % 2 == 0) // so chan
				.forEach(System.out::println);
	}

}
