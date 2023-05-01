package com.interfaces.fi;

interface MathOperation {
	int operation(int a, int b);
}

public class Complex {

	private int operation(int a, int b, MathOperation mo) {
		return mo.operation(a, b);
	}

	public static void main(String[] args) {
		int x = 2, y = 3;
		MathOperation add = (a, b) -> a + b;
		MathOperation mul = (int a, int b) -> a * b;
		MathOperation pow = (int a, int b) -> (int) Math.pow(a, b);
		System.out.println(String.format("%d + %d = %d", x, y, add.operation(x, y)));
		System.out.println(String.format("%d * %d = %d", x, y, mul.operation(x, y)));
		Complex lambda = new Complex();
		System.out.println(String.format("%d^%d = %d", x, y, lambda.operation(x, y, pow)));
	}

}
