package lambda.method.reference;

import java.util.Arrays;

@FunctionalInterface
interface ExecuteFunction {
	int execute(int a, int b);
}

class MathUtils {

	public static int sum(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}

	public int sumOf(int a, int b) {
		return a + b;
	}
}

/*-
 * Đây chính là lập trình hướng hàm, mục đích của nó là đưa hành vi vào hàm. Hay
 * nói cách khác là đưa thêm các đoạn code vào hàm như là một parameter.
 * => Lập trình hướng hàm là đưa hành vi vào hàm.
 */
public class MethodReference {

	public static int doAction(int a, int b, ExecuteFunction ef) {
		return ef.execute(a, b);
	}

	public static void main(String[] args) {

		int a = 4;
		int b = 3;

		// Class::staticMethod
		int sum = doAction(a, b, MathUtils::sum); // doAction(a, b, (x, y) -> x + y);
		System.out.println(a + " + " + b + " = " + sum);

		int minus = doAction(a, b, MathUtils::minus);
		System.out.println(a + " - " + b + " = " + minus);

		// object::instanceMethod
		MathUtils instance = new MathUtils();
		int sumOf = doAction(a, b, instance::sumOf);
		System.out.println(a + " + " + b + " = " + sumOf);

		// Class::instanceMethod
		String[] arr = { "Java", "C++", "PHP", "C#", "Javascript" };
		Arrays.sort(arr, (s1, s2) -> s1.compareToIgnoreCase(s2));
		Arrays.sort(arr, String::compareToIgnoreCase);

		// Class::new

	}

}
