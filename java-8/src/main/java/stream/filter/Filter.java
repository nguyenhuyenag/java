package stream.filter;

import java.util.stream.Stream;

public class Filter {

	/**
	 * Stream filter() giúp loại bỏ các phần tử dựa trên các tiêu chí nhất định
	 */
	public static void main(String[] args) {

		Stream.iterate(1, t -> ++t) //
				.limit(6) //
				.filter(x -> x % 3 == 0) // chia het cho 3
				.forEach(System.out::println);
	}

}
