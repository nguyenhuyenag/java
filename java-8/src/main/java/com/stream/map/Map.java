package com.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @see lambda.function;
 */
public class Map {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("1", "2", "2", "3", "3", "4", "5");

		// map
		list.stream().map(Integer::parseInt).collect(Collectors.toList());
		list.stream().map(t -> Integer.valueOf(t)).collect(Collectors.toList());

		// mapTo
		ToIntFunction<String> mapper = t -> Integer.parseInt(t);
		
		System.out.println(mapper.applyAsInt("1"));
		
		list.stream() //
				.mapToInt(mapper) 							// -> IntStream
				// .mapToLong(t -> Long.parseLong(t)) 		// -> LongStream
				// .mapToDouble(t -> Double.parseDouble(t)) // -> DoubleStream
				.boxed() 									// -> Stream<T>
				.collect(Collectors.toList());
		
	}
}
