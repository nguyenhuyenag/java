package com.collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ArrayTo {

	private static int[] intArray = { 1, 2, 3, 4 };

	private static Integer[] integerArray = { 1, 2, 3, 4, 5 };

	public static void toList() {
		List<Integer> list1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.asList(integerArray);
		List<Integer> list3 = new ArrayList<>(Arrays.asList(integerArray));
		List<Integer> list4 = Arrays.stream(integerArray).collect(Collectors.toList());
	}

	public static void toSet() {
		Set<Integer> set1 = Arrays.stream(intArray).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = new HashSet<>(Arrays.asList(integerArray));
		Set<Integer> set3 = new HashSet<>();
		Collections.addAll(set3, integerArray);
	}

	public static void IntegerArrayToIntArray() {
		int[] intArray = Arrays.stream(integerArray) //
				.mapToInt(Integer::intValue) //
				.toArray();
	}

	public static void intArrayToIntegerArray() {
		Integer[] integerArray = Arrays.stream(intArray) //
				.boxed() // nguyên thủy -> đối tượng
				.toArray(Integer[]::new);

	}

}
