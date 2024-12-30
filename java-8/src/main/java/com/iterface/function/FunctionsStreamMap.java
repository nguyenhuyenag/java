package com.iterface.function;

import java.util.List;
import java.util.function.Function;

/*-
	+ Stream.map(Function mapper)

	+ Function mapper là hàm ánh xạ (mapping function).
 */
public class FunctionsStreamMap {

	public static void main(String[] args) {
		List<String> list = List.of("Stack", "Java", "Function");
		Function<String, String> upperFunction = s -> s.toUpperCase();
		// list = list.stream().map(upperFunction).toList();
		// list = list.stream().map(String::toLowerCase).toList();
		list = list.stream().map(s -> upperFunction.apply(s)).toList();
		System.out.println(list);
	}

}
