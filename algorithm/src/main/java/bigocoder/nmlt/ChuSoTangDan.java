package bigocoder.nmlt;

import java.util.Scanner;

public class ChuSoTangDan {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			int max = n % 10;
			n /= 10;
			int tmp;
			while (n != 0) {
				tmp = n % 10;
				n /= 10;
				if (tmp >= max) {
					System.out.println("NO");
					return;
				}
				max = tmp;
			}
			System.out.println("YES");
		}
	}
}
