package algorithm.dynamic;

import java.math.BigInteger;

public class Fibonacci {

	static BigInteger fibonacci(int n) {
		if (n < 2) {
			return new BigInteger(String.valueOf(n));
		}
		int length = n + 1;
		BigInteger arr[] = new BigInteger[length];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i < length; i++) {
			arr[i] = arr[i - 1].add(arr[i - 2]);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		int n = 300;
		System.out.println(fibonacci(n));
	}
}
