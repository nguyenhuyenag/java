package com;

public class Main {

	public static int sum(int n) {
		while (n > 9) {
			n = n / 10 + n % 10;
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(sum(1230));
	}

}
