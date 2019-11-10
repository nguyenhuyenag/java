package com.dynamic;

import java.math.BigInteger;

public class Dynamic {

	static void factorial(int n) {
		int length = n + 1;
		BigInteger[] arr = new BigInteger[length];
		arr[0] = BigInteger.ONE; // 0! = 1
		for (int i = 1; i < length; i++) {
			arr[i] = BigInteger.valueOf(i).multiply(arr[i - 1]);
		}
		System.out.println(n + "! = " + arr[n]);
	}

	public static BigInteger fibonacci(int n) {
		BigInteger[] f = new BigInteger[n + 1];
		f[0] = BigInteger.ZERO;
		if (n > 0) {
			f[1] = BigInteger.ONE;
		}
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1].add(f[i - 2]);
		}
		return f[n];
	}

}
