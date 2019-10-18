package bigocoder.nmlt.array;

import java.util.Scanner;

public class NMLT_ARRAY18_XTX {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != x) {
					System.out.println(arr[i] + " ");
				}
			}
		}
	}
}
