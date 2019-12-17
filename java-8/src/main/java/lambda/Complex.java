package lambda;

interface MathOperation {
	int operation(int a, int b);
}

public class Complex {

	private int operation(MathOperation mo, int a, int b) {
		return mo.operation(a, b);
	}

	public static void main(String[] args) {
		int x = 2, y = 3;
		MathOperation add = (a, b) -> a + b;
		MathOperation mul = (int a, int b) -> {
			return a * b;
		};
		MathOperation pow = (int a, int b) -> (int) Math.pow(a, b);
		System.out.println(String.format("%d + %d = %d", x, y, add.operation(x, y)));
		System.out.println(String.format("%d * %d = %d", x, y, mul.operation(x, y)));
		Complex lambda = new Complex();
		System.out.println(String.format("%d^%d = %d", x, y, lambda.operation(pow, x, y)));
	}

}
