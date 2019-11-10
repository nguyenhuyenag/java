package com.collection.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LoopMap {

	public static void loopByForEach(Map<String, Integer> map) {
		map.forEach((k, v) -> System.out.println(k + " => " + v));
	}

	public static void loopByKeySet(Map<String, Integer> map) {
		Set<String> listKey = map.keySet();
		listKey.forEach(k -> System.out.println(k + " => " + map.get(k)));
	}

	public static void loopByEntry(Map<String, Integer> map) {
		Set<Entry<String, Integer>> entrys = map.entrySet();
		entrys.forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
	}

	public static void loopByCollection(Map<String, Integer> map) {
		Collection<Integer> values = map.values();
		System.out.println(values);
	}

	public static void checkKeyInMap(Map<String, Integer> map, String key) {
		Set<String> listKey = map.keySet();
		for (String k : listKey) {
			if (k.equals(key)) {
				System.out.println(true);
				return;
			}
		}
		System.out.println(false);
	}
	
	public static void checkByContainsKey(Map<String, Integer> map, String key) {
		System.out.println(map.containsKey(key));
	}

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put("0" + String.valueOf(i), i);
		}
		
		// loopByEntry(map);
		// loopByKeySet(map);
		// loopByForEach(map);
		// loopByCollection(map);
		// checkKeyInMap(map, "00");
		// checkByContainsKey(map, "00");
		System.out.println(Collections.max(map.keySet()));
		System.out.println(Collections.min(map.keySet()));
		
		System.out.println(Collections.max(map.values()));
		
	}
}
