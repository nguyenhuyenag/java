package bigocoder.nmlt.number;

import java.util.Scanner;

public class CHC3 {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.nextInt();
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] % 3 == 0) {
					// list.add(arr[i]);
					System.out.print(arr[i] + " ");
				}
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] % 3 != 0) {
					// list.add(arr[i]);
					System.out.print(arr[i] + " ");
				}
			}
		}
	}
}
