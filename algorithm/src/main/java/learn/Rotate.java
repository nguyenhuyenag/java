package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotate {

	// Chuyển k lần
	static void rotate(int[] arr, int k) {
		for (int i = 1; i <= k; i++) {
			move(arr);
		}
	}

	static void move(int[] arr) {
		int i, n = arr.length;
		int tmp = arr[0];
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = tmp;
	}

	static <T> void moveByCollection(T[] arr, int k) {
		List<T> list = Arrays.asList(arr);
		System.out.println("Before: " + Arrays.toString(arr));
		Collections.rotate(list, k);
		System.out.println("After: " + Arrays.toString(list.toArray()));
	}

	/**
	 * Chuyển k phần tử đầu tiên về cuối mảng
	 */
	public static void main(String[] args) {
		int k = 3; // chuyển k phần tử
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println("Before:\t" + Arrays.toString(arr));
		rotate(arr, k);
		System.out.println("After:\t" + Arrays.toString(arr));
	}

}
