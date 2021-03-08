package com.collection.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import common.util.RandomUtils;

public class SetApi {

	static List<Integer> list = RandomUtils.getListInteger(5, 0, 5);

	public static void iSet() {
		System.out.println("List:\t\t" + Arrays.toString(list.toArray()));

		Set<Integer> set = new HashSet<>(list); // không thứ tự
		System.out.println("Set:\t\t" + set);

		Set<Integer> treeSet = new TreeSet<>(list); // tự động tăng
		System.out.println("TreeSet:\t" + treeSet);

		// Collections.reverseOrder()
		Set<Integer> tree = new TreeSet<>(Comparator.reverseOrder()); // đảo ngược
		tree.addAll(list);
		System.out.println("Reverse:\t" + tree);

		Set<Integer> linked = new LinkedHashSet<>(list); // theo thứ tự chèn
		System.out.println("LinkedHashSet:\t" + linked);
	}

	public static void main(String[] args) {
		iSet();
	}
}
