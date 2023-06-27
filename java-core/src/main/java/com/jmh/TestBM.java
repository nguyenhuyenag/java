package com.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

public class TestBM {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@Fork(value = 1)
	@Warmup(iterations = 2)
	@Measurement(iterations = 1)
	public void init() {
		// fib(52);
		// fibbonaci(300);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public double fibbonaci(int n) {
		double prev = 0d, next = 1d, result = 0d;
		for (int i = 0; i < n; i++) {
			result = prev + next;
			prev = next;
			next = result;
		}
		return result;
	}

}
