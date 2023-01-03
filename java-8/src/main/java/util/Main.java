package util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

public class Main {
	
	public static void main(String[] agrs) {
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);

		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
		Spliterator<Integer> spliterator = values.stream().spliterator();
		while (spliterator.tryAdvance(e -> System.out.print(e + " ")));

	}

}
