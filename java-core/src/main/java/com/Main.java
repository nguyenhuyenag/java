package com;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Main {

	public static void main(String[] args) {
		final int[] array = { 0, 1, 2, 3, 4, 5 };
		int[] result = ArrayUtils.insert(1111, array, -11);
		System.out.println(Arrays.toString(result));
	}

}
