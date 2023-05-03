package com.lambda.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAndComparator {

	public static void withoutLambda(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	public static void withLambda(List<Integer> list) {
		Collections.sort(list, (n1, n2) -> n1 - n2);
		// Hoặc Collections.sort(list, (n1, n2) -> n1.compareTo(n2));
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
		withoutLambda(list);
		System.out.println(list);
		List<Integer> listInt = Arrays.asList(1, -12, 0, 2, -11, 5);
		withLambda(listInt);
		System.out.println(listInt);
	}

}
