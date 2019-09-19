package stream.init;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimitiveStream {

	// filter odd number
	static void fromArray(int[] arr) {
		arr = IntStream.of(arr) //
				.filter(t -> t % 2 != 0) //
				.toArray();
		System.out.println(Arrays.toString(arr));
	}

	static void fromRange() {
		IntStream.range(0, 5).average().ifPresent(System.out::println);
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		fromArray(arr);
		// fromRange();

		// DoubleStream.of(1, 2, 3).forEach(System.out::println); // 1.0 2.0 3.0

		// LongStream.range(1, 4).forEach(System.out::println); // 1 2 3

		// LongStream.of(1, 2, 3).forEach(System.out::println); // 1 2 3

	}

}
