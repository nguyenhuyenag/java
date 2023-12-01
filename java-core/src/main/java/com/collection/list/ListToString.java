package com.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToString {

	public static String join1(List<String> list, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (i == 0) {
				sb.append(s);
				continue;
			}
			sb.append(delimiter + s);
		}
		return sb.toString();
	}

	public static String join2(List<String> list, String delimiter) {
		return list.stream().collect(Collectors.joining(delimiter));
	}

	public static String join3(List<String> list, String delimiter) {
		return String.join(delimiter, list);
	}
	
	public static void join4() {
		List<String> list = Arrays.asList("A", "B", "C", "D");

		String result6 = list.stream().collect(Collectors.joining());
		System.out.println(result6);

		String result7 = list.stream().collect(Collectors.joining("*"));
		System.out.println(result7);

		String result8 = list.stream().collect(Collectors.joining("_", "PREFIX^", "^SUFFIX"));
		System.out.println(result8);
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Nguyen", "Van", "Viet", "Nam");
		System.out.println(join1(names, "-"));
		System.out.println(join2(names, "-"));
		System.out.println(join3(names, "-"));
		join4();
	}

}
