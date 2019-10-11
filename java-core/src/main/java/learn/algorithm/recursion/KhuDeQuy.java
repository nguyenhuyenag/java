package learn.algorithm.recursion;

public class KhuDeQuy {

	/**
	 * @see learn.algorithm.recursion.Recursions#digitSum
	 */
	public static String toBinary(int n) {
		String str = "";
		while (n != 0) {
			str = n % 2 + str;
			n = n / 2;
		}
		return str;
	}

	public static int sumDigit(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static int firstDigit(int n) {
		while (n > 10) {
			n /= 10;
		}
		return n;
	}

	public static int reverseNumber(int n) {
		int rev = 0;
		while (n > 0) {
			rev = rev * 10 + n % 10;
			n = n / 10;
		}
		return rev;
	}

}
