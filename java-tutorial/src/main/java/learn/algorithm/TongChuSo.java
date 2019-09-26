package learn.algorithm;

public class TongChuSo {

	// Tính tổng các chữ số
	static int recursion(int n) {
		if (n == 0) {
			return 0;
		}
		return recursion(n / 10) + n % 10;
	}

	static int sumDigit(int n) {
		if (n < 9) {
			return n;
		}
		int sum = recursion(n);
		return sumDigit(sum);
	}

	static int sumDigit(int n, int k) {
		return sumDigit(k * n);
	}

	public static void main(String[] args) {
		System.out.println(sumDigit(23, 10));
	}

}
