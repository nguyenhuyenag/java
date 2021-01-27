package codewars.number;

import java.util.Arrays;

// Sắp xếp số lẻ tăng dần, số chẵn giữ nguyên vị trí
public class SortTheOdd {

	public static int[] sortArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] % 2 == 1 && arr[j] % 2 == 1) {
					if (arr[i] > arr[j]) {
						int t = arr[i];
						arr[i] = arr[j];
						arr[j] = t;
					}
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 23, 1, 9, 8, 5, 0, 7, 12 };
		// bubbleSort(arr);
		System.out.println(Arrays.toString(sortArray(arr)));
	}

}
