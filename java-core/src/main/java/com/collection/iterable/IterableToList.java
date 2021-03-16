package com.collection.iterable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IterableToList {

	public static void main(String[] args) {
		Iterable<String> itr = Arrays.asList("Iterable", "to", "List");
		List<String> list = StreamSupport.stream(itr.spliterator(), false) //
				.collect(Collectors.toList());
		list.forEach(t -> System.out.println(t));
	}

}
