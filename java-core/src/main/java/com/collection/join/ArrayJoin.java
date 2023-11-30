package com.collection.join;

import org.apache.commons.lang3.StringUtils;

public class ArrayJoin {

	public static void main(String[] args) {
		String[] arr = { "a", "b", "c", "d" };
		String join = StringUtils.join(arr, "-");
		System.out.println(join);
	}

}
