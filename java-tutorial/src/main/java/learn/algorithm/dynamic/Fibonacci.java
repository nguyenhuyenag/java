package learn.algorithm.dynamic;

import java.math.BigInteger;

public class Fibonacci {

	static void factorial(int n) {
		int length = n + 1;
		BigInteger[] arr = new BigInteger[length];
		arr[0] = BigInteger.ONE; // 0! = 1
		for (int i = 1; i < length; i++) {
			arr[i] = BigInteger.valueOf(i).multiply(arr[i - 1]);
		}
		// System.out.println(Arrays.toString(arr));
		System.out.println(n + "! = " + arr[n]);
	}

	/*-
	 * F(0) = 0
	 * F(1) = 1
	 * F(n) = F(n - 1) + F(n - 2)
	 */
	static void fibonacci(int n) {
		BigInteger[] F = new BigInteger[n + 1];
		F[0] = BigInteger.ZERO;
		if (n > 0) {
			F[1] = BigInteger.ONE;
		}
		for (int i = 2; i < F.length; i++) {
			F[i] = F[i - 1].add(F[i - 2]);
		}
		// System.out.println(Arrays.toString(F));
		System.out.println("F(" + n + ") = " + F[n]);
	}

	public static void main(String[] args) {
		int n = 33;
		factorial(n);
		fibonacci(n);
	}
}
