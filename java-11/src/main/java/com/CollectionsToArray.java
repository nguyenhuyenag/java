package com;

import java.util.Arrays;
import java.util.List;

public class CollectionsToArray {

	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("a", "b", "c");
		String[] oldWay = nameList.toArray(new String[nameList.size()]);
		String[] newWay = nameList.toArray(String[]::new);
		System.out.println(oldWay.length + newWay.length);
	}

}
