package com.v9.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectors {

	public static void main(String[] args) {
		List<String> numbers = List.of("a", "a", "c", "b", "b", "d", "e");
		Map<String, Long> result = numbers.stream()
				// .filter(val -> val > 3)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
				// .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result);
	}

}
