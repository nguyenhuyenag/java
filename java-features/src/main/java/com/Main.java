package com;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		var ids = List.of(1, 2, 3, 4, 5);
		try {
			// get an unmodifiable list
			List<Integer> copyOfIds = List.copyOf(ids);
			copyOfIds.add(6);
		} catch (UnsupportedOperationException e) {
			System.out.println("Collection is not modifiable.");
		}
	}

}