package stream.collectors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBy {

	// Count word
	public static void main(String[] args) {
		
		// A = 3, B = 2, C = 1, E = 1
		List<String> list = Arrays.asList("A", "B", "A", "C", "A", "B", "D");

		Map<String, Long> groupBy = list.stream() //
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(groupBy);

		// sort map
		Map<String, Long> finalMap = new LinkedHashMap<>();
		groupBy.entrySet().stream() //
				.sorted(Map.Entry.<String, Long>comparingByKey()) //
				// .sorted(Map.Entry.<String, Long>comparingByKey().reversed()) //
				.forEachOrdered(m -> finalMap.put(m.getKey(), m.getValue()));
		System.out.println(finalMap);

	}

}
