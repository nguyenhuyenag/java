package bigocoder.nmlt;

import java.util.Scanner;

public class Pascal {

	static int C(int k, int n) {
		if (k == 0 || k == n)
			return 1;
		if (k == 1)
			return n;
		return C(k - 1, n - 1) + C(k, n - 1);
	}

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = n; j > i; j--) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
					System.out.print(C(j, i) + " ");
				}
				System.out.println();
			}
		}
	}

}
