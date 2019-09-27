package learn.algorithm;

import java.util.Arrays;

public class SplitArray {

	static void splitArray(int[] arr) {
		int i, j, k;
		int n = arr.length;
		for (i = 1; i < n; i++) {
			for (j = 1; j < n; j++) {
				for (k = 1; k < n; k++) {
					if (i + j + k == n) {
						System.out.println( //
							Arrays.toString(Arrays.copyOfRange(arr, 0, i)) + ", " + //
							Arrays.toString(Arrays.copyOfRange(arr, i, i + j)) + ", " + //
							Arrays.toString(Arrays.copyOfRange(arr, i + j, n)) //
						);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		splitArray(arr);
	}

}
