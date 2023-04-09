package com.v10;

import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableCollections {

	// copyOf(), toUnmodifiableList(), toUnmodifiableSet(), toUnmodifiableMap()
	public static void main(String[] args) {
		var ids = List.of(1, 2, 3, 4, 5);
		try {
			List<Integer> copyOfIds = List.copyOf(ids); // get an unmodifiable list
			copyOfIds.add(6);
		} catch (UnsupportedOperationException e) {
			System.out.println("Collection is not modifiable");
		}
		try {
			// get an unmodifiable list
			List<Integer> evenNumbers = ids.stream() //
					.filter(i -> i % 2 == 0) //
					.collect(Collectors.toUnmodifiableList());
			evenNumbers.add(6);
		} catch (UnsupportedOperationException e) {
			System.out.println("Collection is not modifiable");
		}
	}

}
