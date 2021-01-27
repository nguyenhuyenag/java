package com;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = { 1, 1, 1, 2, 1, 1 };
		Arrays.sort(arr, (x, y) -> x - y);
		System.out.println(Arrays.toString(arr));
	}

}
