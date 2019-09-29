package learn;

public class Main {

	public static int gcd(int a, int b) {
		if (a <= b) {
			throw new IllegalArgumentException("a must be greater than b");
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		System.out.println(gcd(a, b));
	}

}
