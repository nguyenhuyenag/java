package problem.array;

import java.util.Scanner;

public class NMLT_ARRAY09_TD_2 {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int n = io.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.nextInt();
			}
			int min = arr[0], max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
				}
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			System.out.println(Math.max(Math.abs(min), Math.abs(max)));
		}
	}

}
