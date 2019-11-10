package com.recursion;

public class Recursions {

	public static int sumDigit(int n) {
		if (n == 0) {
			return n;
		}
		return sumDigit(n / 10) + n % 10;
	}

	public static int gcd(int a, int b) {
		if (a <= b) {
			throw new IllegalArgumentException("a must be greater than b");
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		// a * b = gcd(a, b) * lcm(a, b)
		return (a * b) / gcd(a, b);
	}

	public static String toBinary(int n) {
		if (n <= 1) {
			return String.valueOf(n);
		}
		return toBinary(n / 2) + String.valueOf(n % 2);
	}

	private static long count = 0;

	public static int collatzConjecture(int n) {
		boolean even = n % 2 == 0;
		System.out.print(n + " ");
		if (n == 1) {
			return n;
		}
		count++;
		if (even) {
			return collatzConjecture(n / 2);
		} else {
			return collatzConjecture(3 * n + 1);
		}
	}

	public static void main(String[] args) {
		int n = 27;
		// count = 0;
		collatzConjecture(n);
		System.out.println();
		System.out.println(count);
	}

}
