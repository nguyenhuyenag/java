package com.map;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Map với key giống nhau
 */
public class MultiMap {

	public static void main(String[] args) {
		Multimap<String, String> map = ArrayListMultimap.create();
		String key = "key1";
		map.put(key, "firstValue");
		map.put(key, "secondValue");
		map.put("key2", "thirdValue");
		
		System.out.println(map);
		
		System.out.println("Size: " + map.size());
		
		Collection<String> values = map.get(key);
		System.out.println(values);
		
		// Phương thức get() không bao giờ trả về giá trị null
		System.out.println(map.get("key3"));
	}

}
