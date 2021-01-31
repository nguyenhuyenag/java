package com.basic.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWordInText {

	public static void useSet(String text) {
		String[] arr = text.trim().split("\\s+");
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>(list);
		for (String word : set) {
			// StringUtils.countMatches(text, word);
			System.out.println(word + " => " + Collections.frequency(list, word));
		}
	}

	public static Map<String, Integer> useMap(String text) {
		String[] arr = text.trim().split("\\s+");
		Map<String, Integer> map = new LinkedHashMap<>();
		for (String word : arr) {
			if (!map.containsKey(word)) {
				map.put(word, 1); // nếu chưa có thì thêm vào map và đếm là 1
			} else {
				map.put(word, map.get(word) + 1); // ngược lại, tăng đếm lên
			}
		}
		return map;
	}

	public static Map<String, Long> useGroupBy(String text) {
		String[] arr = text.trim().split("\\s+");
		try (Stream<String> stream = Arrays.asList(arr).stream()) {
			return stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		}
	}

	public static void count(String text) {
		Map<String, Integer> map = useMap(text);
		// Map<String, Long> map = useGroupBy(text);
		map.forEach((k, v) -> System.out.println(k + " => " + v));
	}

	public static void main(String[] args) {
		// Lorem lorem = LoremIpsum.getInstance();
		// String text = lorem.getWords(1, 100);
		String text = "A C A C A S A S D D A S D D A E F A B C D A E F A B C D D A S D D A E F A B C D B B B C D B B";
		// useSet(text);
		count(text);
	}

}
