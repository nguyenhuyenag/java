package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filter = list.stream().filter(t -> !t.isEmpty()).collect(Collectors.toList());
		System.out.println(filter);
		filter.forEach(System.out::println);
	}
}
