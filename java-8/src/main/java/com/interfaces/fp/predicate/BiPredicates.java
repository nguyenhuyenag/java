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
		BiPredicate<String, Integer> filter = (t, u) -> t.length() > u;
		List<String> filteredNames = filterList(names, filter, 4);
		System.out.println(filteredNames); // [Alice, Charlie, David]
	}

	public static <T, U> List<T> filterList(List<T> list, BiPredicate<T, U> predicate, U condition) {
		List<T> result = new ArrayList<>();
		for (T element : list) {
			if (predicate.test(element, condition)) { // element.length() > condition
				result.add(element);
			}
		}
		return result;
	}

}
