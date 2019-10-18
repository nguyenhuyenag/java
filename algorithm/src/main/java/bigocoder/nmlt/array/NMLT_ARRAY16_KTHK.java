package bigocoder.nmlt.array;

import java.util.Scanner;

public class NMLT_ARRAY16_KTHK {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.nextInt();
			}
			int i, length = arr.length;
			for (i = 0; i < length; i++) {
				if (i == length - 1) {
					System.out.println("NO");
					return;
				}
				if (arr[i] == 0 && arr[i + 1] == 0) {
					System.out.println("YES");
					return;
				}
			}
		}
	}
}
