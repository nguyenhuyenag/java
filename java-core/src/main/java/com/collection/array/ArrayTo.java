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

	static int[] ints = { 1, 2, 3, 4 };

	static Integer[] Ints = { 1, 2, 3 };

	public static void toList() {
		List<Integer> list1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.asList(Ints);
		List<Integer> list3 = new ArrayList<>(Arrays.asList(Ints));
		List<Integer> list4 = Arrays.stream(Ints).collect(Collectors.toList());
	}

	public static void toSet() {
		Set<Integer> set1 = Arrays.stream(ints).boxed().collect(Collectors.toSet());
		
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(Ints));
		
		Set<Integer> set3 = new HashSet<Integer>();
		Collections.addAll(set3, Ints);
	}

}
