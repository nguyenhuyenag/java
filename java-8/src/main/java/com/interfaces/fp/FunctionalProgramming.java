package com.interfaces.fp;

/**
 * - Lập trình hướng hàm là đưa hành vi vào hàm, mục đích của nó là đưa hành vi
 * vào hàm. Hay nói cách khác là đưa thêm các đoạn code vào hàm như là một
 * parameter.
 */
public class FunctionalProgramming {

	@FunctionalInterface
	interface NumberFunction {
		int process(int a, int b);
	}

	public static int doAction(int a, int b, NumberFunction function) {
		return function.process(a, b);
	}

	public static void main(String[] args) {
		int a = 3, b = 4;
		
		int sum = doAction(a, b, (x, y) -> x + y);
		System.out.println(a + " + " + b + " = " + sum);

		int product = doAction(a, b, (x, y) -> x * y);
		System.out.println(a + " * " + b + " = " + product);

		int max = doAction(a, b, Math::max);
		System.out.println("max(" + a + ", " + b + ") = " + max);
	}

}
