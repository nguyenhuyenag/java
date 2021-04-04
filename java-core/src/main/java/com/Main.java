package com;

public class Main {

	public static void show(int[] A, int n) {
		if (n >= 0) {
			System.out.println(A[n]);
			show(A, n - 1);
		}
		return;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		show(A, A.length - 1);
	}

}
