package stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SummarizingDouble {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP", "C");

		IntSummaryStatistics su = list.stream().collect(Collectors.summarizingInt(String::length));

		System.out.println(su);
		
		// Trả v�? giá trị trung bình của các phần tử.
		Double avg = list.stream().collect(Collectors.averagingDouble(String::length));
		System.out.println(avg);
		
		//  Trả v�? giá trị tổng của các phần tử.
		Double result = list.stream().collect(Collectors.summingDouble(String::length));
		System.out.println(result);
		
		Comparator<String> c = (s1, s2) -> s1.length() - s2.length();
		
		Optional<String> max = list.stream().collect(Collectors.maxBy(c));
		Optional<String> min = list.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(max);
		System.out.println(min);

	}

}
