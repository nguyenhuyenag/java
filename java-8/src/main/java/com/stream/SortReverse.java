package com.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.util.RandomUtils;

public class SortReverse {

	static void x() {
		
	}

	public static void main(String[] args) {

		List<Integer> list = RandomUtils.getRandomListInt(10, -10, 20);

		// Stream sort reverse
		System.out.println("Stream sort reverse \t\t"
				+ list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

		Collections.shuffle(list);

		// lambda
		List<Integer> lambda = list.stream().sorted((n1, n2) -> n2 - n1).collect(Collectors.toList());
		System.out.println("Stream sort lambda \t\t" + lambda);

		Collections.shuffle(list);

		// Collection sort
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("Collections sort reverse \t" + list);

		Collections.shuffle(list);

		// Array sort
		Integer[] array = list.stream().toArray(Integer[]::new);
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println("Arrays sort reverse \t\t" + Arrays.toString(array));

		// Collections.shuffle(list);
		// System.out.println(Arrays.toString(list.toArray()));

	}

}
