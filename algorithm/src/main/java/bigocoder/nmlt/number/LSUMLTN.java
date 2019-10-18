package bigocoder.nmlt.number;

import java.util.Scanner;

public class LSUMLTN {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int S = 1;
			int n = io.nextInt();
			for (int i = 2; i < n; i++) {
				S += i;
				// if (S > n) {// NMLT_LOOP07_SSUMGTN
				// System.out.println(i);
				// return;
				// }
				if (S >= n) {
					System.out.println(i - 1);
					return;
				}
			}
		}
	}
}
