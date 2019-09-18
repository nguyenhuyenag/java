package learn;

import java.util.Arrays;

public class Main {

	static int inc;

	public static int find(int[] arr) {
		inc = 1;
		Arrays.stream(arr).sorted().forEach(i -> {
			if (inc != i) {
				return;
			}
			inc++;
		});
		return inc;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 }; // 5
		// int[] arr = { 1, 3, 4, 5, 6, 9 }; // 2
		// int[] arr = { 2, 4, 8, 9, 3 }; // 1
		// int[] arr = { 2, 3, -7, 6, 8, 1, -10, 15 }; // 4
		System.out.println(find(arr));
	}
}
