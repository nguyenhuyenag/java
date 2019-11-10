package com.generation;

import java.util.Arrays;

/*-
 * Cho A = {1, 2,..., n}, liệt kê các chỉnh hợp lặp chập k của n của A
 * 
 * Với n = 2, k = 3 thì ta được (111), (112), (121), (122), (211), (212), (221), (222).
 */
public class ChinhHopLap {

	static void output(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 2;
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		output(arr);
		for (int i = n - 1; i >= 0; i--) { // Xét từ cuối dãy về đầu
			if (arr[i] < n) { // chữ số có giá trị chưa bằng n
				arr[i] += 1; // tăng lên 1
				Arrays.fill(arr, i + 1, n, 1); // Gán tất cả phần tử sau vị trí đó = 1
				output(arr);
				i = n;
			}
		}
	}

}
