package learn.basic.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class CountWord {

	public static Map<String, Integer> useSet(String text) {
		String[] arr = text.trim().split("\\s+");
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>(list);
		Map<String, Integer> map = new HashMap<>();
		for (String word : set) {
			map.put(word, Collections.frequency(list, word));
		}
		return map;
	}
	
	public static Map<String, Integer> useSet2(String text) {
		String[] arr = StringUtils.split(text, "\\s+");
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>(list);
		Map<String, Integer> map = new HashMap<>();
		for (String word : set) {
			map.put(word, Collections.frequency(list, word));
			// map.put(word, StringUtils.countMatches(text, word));
		}
		return map;
	}

	public static Map<String, Integer> useMap(String text) {
		Integer count;
		String[] arr = text.trim().split("\\s+");
		Map<String, Integer> map = new HashMap<>();
		for (String key : arr) {
			count = map.get(key);
			// Nếu chưa có thì set count = 0 để bắt đầu đếm
			if (Objects.isNull(count)) {
				count = 0;
			}
			// Đếm
			map.put(key, ++count);
		}
		return map;
	}

	public static Map<String, Integer> useLinkedHashMap(String text) {
		String[] arr = text.trim().split("\\s+");
		Map<String, Integer> map = new LinkedHashMap<>();
		for (String key : arr) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		return map;
	}

	public static Map<String, Long> useGroupBy(String text) {
		List<String> list = Arrays.asList(text.trim().split("\\s+"));
		return list.stream() //
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static void count(String text) {
		// Map<String, Integer> map = useSet(text);
		// Map<String, Integer> map = useMap(text);
		Map<String, Long> map = useGroupBy(text);
		map.forEach((k, v) -> System.out.println(k + " => " + v));
	}

	public static void main(String[] args) {
		// Lorem lorem = LoremIpsum.getInstance();
		// String text = lorem.getWords(1, 10);
		String text = " A B C D B B";
		count(text);
	}

}
