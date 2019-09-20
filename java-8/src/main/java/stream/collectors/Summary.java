package stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summary {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP", "C");

		IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(String::length));
		System.out.println(intSummary);

		// Độ dài trung bình của các chuỗi
		Double avg = list.stream().collect(Collectors.averagingDouble(String::length));
		System.out.println(avg);

		// Tổng độ dài của các chuỗi
		Double result = list.stream().collect(Collectors.summingDouble(String::length));
		System.out.println(result);

		Comparator<String> c = (s1, s2) -> s1.length() - s2.length();

		// Chuỗi dài nhất
		String max = list.stream().collect(Collectors.maxBy(c)).get();
		System.out.println(max);

		// Chuỗi ngắn nhất
		String min = list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		System.out.println(min);

	}

}
