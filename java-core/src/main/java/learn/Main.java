package learn;

import java.util.Scanner;

public class Main {

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int i, sqrt = (int) Math.sqrt(n) + 1;
		for (i = 2; i < sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int i, a = io.nextInt(), b = io.nextInt();
			for (i = a; i <= b; i++) {
				if (isPrime(i)) {
					System.out.println(i);
				}
			}
		}
	}

}
