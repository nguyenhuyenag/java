package problem.number;

import java.util.Scanner;

public class Power3 {
	
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			while (n % 3 == 0) {
				n /= 3;
			}
			if (n == 1) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
		}
	}
	
}
