package com.cache;

import java.math.BigInteger;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class Test {

	private static LoadingCache<Integer, BigInteger> facMemo = CacheBuilder.newBuilder()
			.build(CacheLoader.from(Test::getFactorial));

	public static BigInteger getFactorial(int n) {
		System.out.println(facMemo.asMap());
		if (n == 0) {
			return BigInteger.ONE;
		}
		return BigInteger.valueOf(n).multiply(facMemo.getUnchecked(n - 1));
	}

	private static LoadingCache<Integer, BigInteger> fiboMemo = CacheBuilder.newBuilder().maximumSize(100)
			.build(CacheLoader.from(t -> getFibonacciNumber(t)));

	public static BigInteger getFibonacciNumber(int n) {
		System.out.println(fiboMemo.asMap());
		if (n == 0) {
			return BigInteger.ZERO;
		} else if (n == 1) {
			return BigInteger.ONE;
		} else {
			return fiboMemo.getUnchecked(n - 1).add(fiboMemo.getUnchecked(n - 2));
		}
	}

	public static void main(String[] args) {
		// BigInteger v = getFactorial(12);
		BigInteger v = getFibonacciNumber(50);
		System.out.println(v.toString());
	}

}
