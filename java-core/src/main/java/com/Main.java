package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("A", 1); // Output: null
		map1.put("B", 2); // Output: null
		map1.put("A", 3); // Output: 1

		Map<String, Integer> map2 = new HashMap<>();
		map2.putIfAbsent("A", 1); // Output: null
		map2.putIfAbsent("B", 2); // Output: null
		map2.putIfAbsent("A", 3); // Output: 1

		System.out.println("map1: " + map1); // Output: {key1=3, key2=2}
		System.out.println("map2: " + map2); // Output: {key1=1, key2=2}

	}

}
