package problem.number;

import java.util.Scanner;

// Kiểm tra một số có phải dạng 2^x * 3^y
public class Power23 {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			while (n != 1) {
				// không chia hết cho 2 & 3
				if (n % 2 != 0 && n % 3 != 0) {
					System.out.println("NO");
					return;
				} else { // chia hết cho 2 hoặc 3
					if (n % 2 == 0) {
						n /= 2;
					}
					if (n % 3 == 0) {
						n /= 3;
					}
				}
			}
			System.out.println("YES");
		}
	}

}
