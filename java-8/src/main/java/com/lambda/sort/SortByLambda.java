package com.lambda.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByLambda {

	public static void withoutLambda(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	public static void withLambda(List<String> list) {
		// Sort by length()
		// Collections.sort(list, (s1, s2) -> s2.length() - s2.length());
		// Sort by alphabet
		Collections.sort(list, (n1, n2) -> n1.compareTo(n2));
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
		withoutLambda(list);
		System.out.println(list);
		withLambda(list);
		System.out.println(list);
	}

}
