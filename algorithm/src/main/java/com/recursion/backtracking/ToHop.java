package com.recursion.backtracking;
//package learn.recursion.backtracking;
//
///**
// * Liệt kê các tổ hợp chập k của n phần tử {1, 2, 3, ... n}
// * 
// * Ví dụ n = 4, k = 3 ta có các tổ hợp sau: (1,2,3) (1,2,4) (1,3,4), (1,2,4)
// */
//public class ToHop {
//
//	static int k, n;
//	static int[] arr;
//
//	static void output() {
//		StringBuilder builder = new StringBuilder();
//		for (int var : arr) {
//			builder.append(var);
//		}
//		System.out.print(builder.toString() + " ");
//	}
//
//	/**
//	 * Kiểm tra k có thuộc array
//	 */
//	static boolean isIn(int[] array, int k) {
//		for (int x : array) {
//			if (x == k) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	static void backtrack(int i) {
//		// for (int j = arr[i - 1] + 1; j <= n - k + i; j++) { // xét các khả năng của j
//		// arr[i] = j; // ghi nhận một giá trị của j
//		// if (i == k - 1) { // nếu cấu hình đã đủ k phần tử
//		// // in một cấu hình ra ngoài
//		// output();
//		// } else {
//		// backtrack(i + 1); // quay lui
//		// }
//		// }
//		for (int v = 1; v <= 4; v++) {
//			if (!isIn(arr, v)) {
//				arr[i] = v;
//				if (i == (k - 1)) {
//					output();
//				} else {
//					backtrack(i + 1);
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		k = 3;
//		n = 3;
//		arr = new int[k];
//		backtrack(0);
//	}
//
//}
