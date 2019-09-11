package stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStream {

	public static void main(String[] args) {

		IntStream.range(0, 5).forEach(System.out::println); // 0, 1, 2, 3, 4

		IntStream.of(1, 2, 3).forEach(System.out::println); // 1 2 3

		DoubleStream.of(1, 2, 3).forEach(System.out::println); // 1.0 2.0 3.0

		LongStream.range(1, 4).forEach(System.out::println); // 1 2 3

		LongStream.of(1, 2, 3).forEach(System.out::println); // 1 2 3

	}

}
