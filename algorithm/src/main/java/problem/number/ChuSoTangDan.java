package problem.number;

import java.util.Scanner;

/**
 * Kiểm tra các chữ số tăng dần
 */
public class ChuSoTangDan {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			int previous, end = n % 10;
			n /= 10;
			while (n > 0) {
				previous = n % 10;
				n /= 10;
				if (previous >= end) {
					System.out.println("NO");
					return;
				}
				end = previous;
			}
			System.out.println("YES");
		}
	}

}
