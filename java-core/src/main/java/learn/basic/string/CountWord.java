package learn.basic.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWord {

	public static Map<String, Integer> useFrequency(String text) {
		String[] arr = text.trim().split("\\s");
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
		for (String word : arr) {
			count = map.get(word);
			// Nếu chưa có thì set count = 0 để bắt đầu đếm
			if (Objects.isNull(count)) {
				count = 0;
			}
			// Đếm
			map.put(word, ++count);
		}
		return map;
	}

	public static Map<String, Long> useGroupBy(String text) {
		List<String> list = Arrays.asList(text.trim().split("\\s+"));
		return list.stream() //
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public static void count(String text) {
		// Map<String, Integer> map = useFrequency(text);
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
