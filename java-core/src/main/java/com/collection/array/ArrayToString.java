package com.collection.array;

import org.apache.commons.lang3.StringUtils;

public class ArrayToString {

	public static void main(String[] args) {
		String[] arr = { "a", "b", "c", "d" };
		
		// Java 8
		String joined1 = String.join(",", arr);
		System.out.println(joined1);
		
		// Apache
		String joined2 = StringUtils.join(arr, "-");
		System.out.println(joined2);
	}

}
