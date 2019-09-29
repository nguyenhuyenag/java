package learn.algorithm.recursion;

public class Recursions {

	public static int digitSum(int n) {
		if (n == 0) {
			return n;
		}
		return digitSum(n / 10) + n % 10;
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
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		int a = 6;
		int b = 5;
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}

}
