package com.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class BasicSample {

	private static LoadingCache<Integer, Long> fibCache = CacheBuilder.newBuilder()
			.build(CacheLoader.from(n -> calculateFibonacciWithCache(n)));

	// Without cache
	public static long calculateFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
	}

	// Cache
	public static long calculateFibonacciWithCache(int n) {
		if (n <= 1) {
			return n;
		}
		return fibCache.getUnchecked(n - 1) + fibCache.getUnchecked(n - 2);
	}

	public static void main(String[] args) throws ExecutionException {
		int n = 40;
		long startTime = System.currentTimeMillis();
		// long fibonacciValue = calculateFibonacci(n);
		long fibonacciValue = calculateFibonacciWithCache(n);
		long endTime = System.currentTimeMillis();
		long timeWithoutCache = endTime - startTime;
		System.out.println("Fibonacci(" + n + ") without cache: " + fibonacciValue);
		System.out.println("Time without cache: " + timeWithoutCache + " ms");
	}

}
