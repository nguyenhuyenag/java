package com.stream.collect.groupby;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> result = items.stream()
				// .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Without sort:\t" + result);
		// Sort a map and add to finalMap
		Map<String, Long> finalMap = new LinkedHashMap<>();
		result.entrySet().stream() //
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()) //
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println("Sort:\t\t" + finalMap);

	}

}
