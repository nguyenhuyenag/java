package learn;

import java.util.Arrays;

public class Main {

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		swap(arr, 0, 1);
		System.out.println(Arrays.toString(arr));
	}

}
