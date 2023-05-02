package com.interfaces.fp.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Tương tự với Predicate nhưng có 2 tham số
 */
public class BiPredicates {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
		BiPredicate<String, Integer> filter = (v1, v2) -> v1.length() > v2;
		List<String> filteredNames = filterList(names, filter, 4);
		System.out.println(filteredNames); // [Alice, Charlie, David]
	}

	public static <T, U> List<T> filterList(List<T> list, BiPredicate<T, U> predicate, U v2) {
		List<T> result = new ArrayList<>();
		for (T element : list) {
			if (predicate.test(element, v2)) { // v1.length() > v2
				result.add(element);
			}
		}
		return result;
	}

}
