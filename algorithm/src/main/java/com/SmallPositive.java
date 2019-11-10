package com;

public class SmallPositive {

	// Mảng đánh dấu
	public static int markArray(int[] arr) {
		int n = arr.length;
		boolean[] mark = new boolean[n + 2];
		for (int i = 0; i < n; i++) {
			if (arr[i] <= 0 || arr[i] > n + 1) {
				continue;
			}
			mark[arr[i]] = true;
		}
		for (int i = 1; i < mark.length; i++) {
			if (!mark[i]) {
				return i;
			}
		}
		return 0;
	}

	/*-
	 * Tìm số nguyên dương nhỏ nhất bị thiếu trong mảng
	 * Input:	{2, 3, 7, 6, 8, -1, -10, 15}
	 * Output: 	1
	 * Input: 	{ 2, 3, -7, 6, 8, 1, -10, 15 }
	 * Output: 	4
	 * Input: 	{1, 1, 0, -1, -2}
	 * Output: 	2
	 */
	public static void main(String[] args) {
		// int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 }; // => 1
		// int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 }; // => 4
		int[] arr = { 1, 3, 6, 4, 5, 2 };
		System.out.println(markArray(arr));
	}

}
