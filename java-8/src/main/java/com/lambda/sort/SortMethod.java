package com.lambda.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMethod {

	public static void print(List<Integer> L1, List<Integer> L2) {
		String s1 = Arrays.toString(L1.toArray());
		String s2 = Arrays.toString(L1.toArray());
		System.out.println(String.format("%s -> %s ", s1, s2));
	}

	public static void streamSorted(List<Integer> list) {
		System.out.println("Stream sorted");
		// Collections.shuffle(list);
		print(list, list.stream().sorted().toList()); // <- Return a new list
	}

	public static void collectionsSort(List<Integer> list) {
		System.out.println("Collection sort");
		List<Integer> cloneList = new ArrayList<>(list);
		Collections.sort(cloneList);
		print(list, cloneList);
	}

	public static void arraysSort(List<Integer> list) {
		System.out.println("Arrays sort");
		Integer[] array = list.stream().toArray(Integer[]::new);
		Arrays.sort(array);
		print(list, Arrays.asList(array));
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 5, 7, -4, 0, 11, -7, 0, 7, 6);
		arraysSort(list);
		streamSorted(list);
		collectionsSort(list);
	}

}
