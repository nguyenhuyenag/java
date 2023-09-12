package com.map;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Set + Function = Map
 */
public class SetFunctionMap {

	public static void main(String[] args) {
		List<String> keys = ImmutableList.of("one", "two", "three");
		Function<String, Integer> valueFunction = key -> key.length();
		Map<String, Integer> keyToLengthMap = buildMap(keys, valueFunction);
		System.out.println(keyToLengthMap);
	}

	private static <K, V> Map<K, V> buildMap(Iterable<K> keys, Function<? super K, V> valueFunction) {
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for (K key : keys) {
			builder.put(key, valueFunction.apply(key));
		}
		return builder.build();
	}

}
