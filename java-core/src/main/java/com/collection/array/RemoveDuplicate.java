package com.collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import common.util.RandomUtils;

public class RemoveDuplicate {

	public static void main(String[] args) {

		List<Integer> list = RandomUtils.getListInteger(10, 1, 20);
		System.out.println("Before: " + Arrays.toString(list.toArray()));

		// stream distinct
		List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
		System.out.println("After: " + Arrays.toString(distinct.toArray()));

		// set
		Set<Integer> set = new HashSet<>(list);
		ArrayList<Integer> arrList = new ArrayList<>(set);
		System.out.println("After: " + Arrays.toString(arrList.toArray()));

		// removeIf
		Set<Integer> setInt = new HashSet<>();
		list.removeIf(t -> !setInt.add(t));
		System.out.println("After: " + Arrays.toString(list.toArray()));

	}

}
