package learn;

public class ForNumber {

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

	/**
	 * Tổng các chữ số
	 */
	public static int sumDigit(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	/**
	 * Chữ số đầu tiên
	 */
	public static int firstDigit(int n) {
		while (n > 10) {
			n /= 10;
		}
		return n;
	}

	/**
	 * Đảo ngược số
	 */
	public static int reverseNumber(int n) {
		int rev = 0;
		while (n > 0) {
			// b = n % 10 => Lấy chữ số ra
			// thêm vào hàng đơn vị
			// ab = 10 * a + b
			rev = rev * 10 + n % 10;
			n = n / 10;
		}
		return rev;
	}

	/**
	 * Kiểm tra các chữ số có phải tăng dần
	 */
	public static boolean increment(int n) {
		int tmp, end = n % 10;
		n /= 10;
		while (n > 0) {
			tmp = n % 10;
			if (tmp > end) {
				return false;
			}
			end = tmp;
			n /= 10;
		}
		return true;
	}

	/**
	 * Ước chung lớn nhất
	 */
	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a; // a hay b cũng được
	}
	
	// 155

}