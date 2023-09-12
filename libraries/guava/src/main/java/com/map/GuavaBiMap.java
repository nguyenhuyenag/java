package com.map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * - Bidirectional Map (map 2 chiều)
 */
public class GuavaBiMap {

	public static void main(String[] args) {
		BiMap<String, Integer> userIdBiMap = HashBiMap.create();

		// Ánh xạ khóa đến giá trị và ngược lại
		userIdBiMap.put("Alice", 1);
		userIdBiMap.put("Bob", 2);
		userIdBiMap.put("Charlie", 3);

		System.out.println(userIdBiMap.get("Bob")); // In ra: 2
		System.out.println(userIdBiMap.inverse().get(3)); // In ra: Charlie
	}

}
