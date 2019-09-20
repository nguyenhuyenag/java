package learn.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {

	public static void listToMap(List<String> list) {
		list.stream() //
				.collect(Collectors.toMap(Function.identity(), String::length)) //
				.forEach((k, v) -> System.out.println(k + ", " + v));
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP");
		listToMap(list);
	}
}
