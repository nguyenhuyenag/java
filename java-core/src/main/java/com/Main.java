package com;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		int[] a = { 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7 };
		Set<Integer> set = new HashSet<>();
		for (int k : a) {
			if (!set.add(k)) {
				System.out.println("Duplicate: " + k);
			}
		}
	}

}
