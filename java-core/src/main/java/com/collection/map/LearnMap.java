package com.collection.map;

import java.util.HashMap;
import java.util.Map;

public class LearnMap {

	/**
	 * - putIfAbsent(k, v): Nếu key không chứa trong HashMap sẽ được thêm mới, nếu
	 * key đã tồn tại thì value sẽ được update thành value mới được truyền vào.
	 * 
	 * - getOrDefault(k, v): Trả về phần tử của key được chỉ định. Nếu key không
	 * chứa trong mảng nó sẽ trả về default value mà chúng ta truyền vào
	 */
	public static void main(String[] args) {
		// Creating an empty HashMap
		Map<Integer, String> hash_map = new HashMap<>();
		hash_map.putIfAbsent(1, "HGA");
		System.out.println(hash_map);

		hash_map.put(1, "replace");
		System.out.println(hash_map);
	}

}
