package com.lambda.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "8", "Consumer");
		// Cách 1
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// Cách 2
		list.forEach(t -> System.out.println(t));

		// Cách 3
		list.forEach(System.out::println);
	}

}
