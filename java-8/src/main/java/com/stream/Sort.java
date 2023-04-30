package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.util.RandomUtils;

public class Sort {

	static void print(List<Integer> l1, List<Integer> l2) {
		String format = String.format("%s > %s ", Arrays.toString(l1.toArray()), //
				Arrays.toString(l1.toArray()));
		System.out.println(format);
	}

	static void streamSorted(List<Integer> list) {
		System.out.println("Stream sorted...");
		Collections.shuffle(list);
		print(list, list.stream().sorted().collect(Collectors.toList()));
	}

	static void collectionsSort(List<Integer> list) {
		System.out.println("Collection sort...");
		Collections.shuffle(list);
		List<Integer> cloneList = new ArrayList<Integer>(list);
		Collections.sort(cloneList);
		print(list, cloneList);
	}

	static void arraysSort(List<Integer> list) {
		System.out.println("Arrays sort...");
		Collections.shuffle(list);
		Integer[] array = list.stream().toArray(Integer[]::new);
		Arrays.sort(array);
		print(list, Arrays.asList(array));
	}

	public static void main(String[] args) {
		List<Integer> list = RandomUtils.getRandomListInt(10, -10, 20);
		streamSorted(list);
		collectionsSort(list);
		arraysSort(list);
	}

}
