package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example1 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP");

		// Map<String, Integer> result =
		// list.stream().collect(Collectors.toMap(Function.identity(), t ->
		// t.length()));

		Map<String, Integer> result = list.stream().collect(Collectors.toMap(Function.identity(), String::length));

		System.out.println(result);

		List<String> list5 = Arrays.asList("Java", "C++", "C#", "PHP");

		List<String> result5 = list5.stream().collect(Collectors.collectingAndThen(Collectors.toList(), x -> x.subList(0, 2)));

		System.out.println(result5);

	}
}
