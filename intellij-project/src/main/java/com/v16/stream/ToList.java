package com.v16.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ToList {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2", "3");
		List<Integer> oldStyle = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> newStyle = list.stream().map(Integer::parseInt).toList();
	}

}
