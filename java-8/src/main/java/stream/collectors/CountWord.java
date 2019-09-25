package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWord {

	public static void main(String[] args) {

		// A = 3, B = 2, C = 1, E = 1
		List<String> list = Arrays.asList("A", "B", "A", "C", "A", "B", "D");

		// grouping by
		Map<String, Long> groupBy = list.stream() //
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(groupBy);

	}

}
