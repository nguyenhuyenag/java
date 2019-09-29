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
		return (a * b) / gcd(a, b);
	}

	public static String toBinary(int n) {
		if (n <= 1) {
			return String.valueOf(n);
		}
		return toBinary(n / 2) + String.valueOf(n % 2);
	}

	public static void main(String[] args) {
		System.out.println(toBinary(3));
	}

}
