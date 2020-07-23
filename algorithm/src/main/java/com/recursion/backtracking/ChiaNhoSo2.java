package com.recursion.backtracking;

/*
	Tìm tất cả các cách để cộng ra một số nguyên bằng 4 số nguyên dương a <= b <= c <= d

	N = 5 có 1 cách: 1 + 1 + 1 + 2
	N = 6, có 2 cách: 1 + 1 + 1 + 3; 1 + 1 + 2 + 2
*/
public class ChiaNhoSo2 {

	static int R;
	static int n = 4;
	static int[] A = { 1, 1, 1, 1 };

	static void init(int r) {
		R = r;
	}

	static void printResult() {
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	static boolean isAEqualSum() {
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += A[i];
		}
		return s == R;
	}

	static void backtrack(int i) {
		int start, end = R - 3 + 1;
		if (i == 0) {
			start = A[0];
		} else {
			start = A[i - 1];
		}
		for (int x = start; x < end; x++) {
			A[i] = x;
			if (A[i] >= start) {
				if (i == n - 1) {
					if (isAEqualSum()) {
						printResult();
					}
				} else {
					backtrack(i + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		init(10);
		backtrack(0);
	}

}
