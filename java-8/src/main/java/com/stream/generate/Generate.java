package com.stream.generate;

import java.util.UUID;
import java.util.stream.Stream;


/*-
 * 		<T> Stream<T> generate(Supplier<T> s)
 */
public class Generate {

	public static void main(String[] agrs) {
		Stream.generate(() -> UUID.randomUUID().toString()) //
				.limit(10) //
				.forEach(t -> System.out.println(t));
	}

}
