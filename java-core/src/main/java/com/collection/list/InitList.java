package com.collection.list;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InitList {
	
	public static void main(String[] args) {
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		List<Integer> list = IntStream.rangeClosed(1, 10) //
				.boxed() //
				.collect(Collectors.toList());
		while (list.size() > 0) {
			int i = ThreadLocalRandom.current().nextInt(0, (list.size() - 1) + 1);
			System.out.println(list.get(i));
			list.remove(i);
		}
	}
	
}
