package learn.algorithm.recursion;

public class TongChuSo {

	// Tính tổng các chữ số của số nguyên dương
	static int digitSum(int n) {
		if (n == 0) {
			return n;
		}
		return digitSum(n / 10) + n % 10;
	}

	public static void main(String[] args) {
		int n = 111;
		System.out.println(digitSum(n));
	}

}
