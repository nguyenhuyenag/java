package com.interfaces.fi;

class MathUtils {

	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static int minus(int a, int b) {
		return a - b;
	}

}

@FunctionalInterface
interface NumberFunction {
	int process(int a, int b);
}

/**
 * - Lập trình hướng hàm là đưa hành vi vào hàm. mục đích của nó là đưa hành vi
 * vào hàm. Hay nói cách khác là đưa thêm các đoạn code vào hàm như là một
 * parameter.
 */
public class FunctionalProgramming {

	public static int doAction(int a, int b, NumberFunction function) {
		return function.process(a, b);
	}

	public static void main(String[] args) {
		int a = 3, b = 4;
		
		int sum = doAction(a, b, MathUtils::sum);
		System.out.println(a + " + " + b + " = " + sum);
		
		int minus = doAction(a, b, (x, y) -> x - y);
		System.out.println(a + " - " + b + " = " + minus);
	}

}
