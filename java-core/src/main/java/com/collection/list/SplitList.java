package com.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitList {

	public static <T> List<List<T>> splitList(List<T> list, int nSubList) {
		int total = list.size();
		int elementPerSubList = total / nSubList;
		List<List<T>> lists = new ArrayList<>();
		for (int i = 0; i < total; i += elementPerSubList) {
			int end = Math.min(i + elementPerSubList, total);
			lists.add(list.subList(i, end));
		}
		// lists.forEach(t -> System.out.println(Arrays.toString(t.toArray())));
		return lists;
	}

	public static <T> List<List<T>> splitListAll(List<T> list, int nSubList) {
		int total = list.size();
		if (total % nSubList == 0) {
			return splitList(list, nSubList);
		}
		List<List<T>> lists = new ArrayList<>();
		lists.add(list.subList(0, total % nSubList));
		lists.addAll(splitList(list.subList(total % nSubList, total), nSubList));
		return lists;
	}

	public static void main(String[] args) {
		int size = 4;
		int page = 3;
		List<Integer> list = IntStream.rangeClosed(1, size) //
				.boxed() //
				.collect(Collectors.toList());
		// splitList(list, 3);
		splitListAll(list, page).forEach(t -> System.out.println(Arrays.toString(t.toArray())));
	}

}
