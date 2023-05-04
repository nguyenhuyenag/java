package com.lambda.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.util.RandomUtils;

public class SortReverse {

	public static void byComparatorReversed(List<Integer> list) {
		Collections.shuffle(list);
		Comparator<Integer> comparator = (a, b) -> a - b;
		list.sort(comparator.reversed());
		System.out.println(list);
	}

	public static void byComparatorReverseOrder(List<Integer> list) {
		Collections.shuffle(list);
		list = list.stream().sorted((a, b) -> b - a).toList();
		// list = list.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(list);
	}

	public static void byCollectionsReverseOrder(List<Integer> list) {
		Collections.shuffle(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}

	public static void byArraysSort(List<Integer> list) {
		Collections.shuffle(list);
		Integer[] array = list.stream().toArray(Integer[]::new);
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		List<Integer> list = RandomUtils.getRandomListInt(10, -10, 50);
		byComparatorReversed(list);
		byComparatorReverseOrder(list);
		byCollectionsReverseOrder(list);
		byArraysSort(list);
	}

}
