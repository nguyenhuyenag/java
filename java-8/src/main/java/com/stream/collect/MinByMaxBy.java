package com.stream.collect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tìm phần tử lớn nhất, nhỏ nhất trong một Stream theo tiêu chí nào đó
 */
public class MinByMaxBy {

	public static Comparator<String> byLength() {
		Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
		return comparator;
	}

	public static Comparator<String> byAlphabet() {
		return Comparator.naturalOrder(); // (s1, s2) -> s1.compareTo(s2);
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C++", "C#", "PHP", "C", "Python", "Golang");

		Comparator<String> comparator = byLength();
		// Comparator<String> comparator = byAlphabet();

		String min = list.stream().collect(Collectors.minBy(comparator)).get();
		String max = list.stream().collect(Collectors.maxBy(comparator)).get();

		list.sort(comparator);

		System.out.println("List: " + list);
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
	}

}
