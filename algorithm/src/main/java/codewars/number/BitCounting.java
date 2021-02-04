package codewars.number;

// Đếm số bit 1 trong chuỗi nhị phân được tạo bởi số nguyên n
public class BitCounting {

	public static int countBits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n % 2) == 1) {
				count++;
			}
			n = n / 2;
		}
		return count;
	}

	public static int _countBits(int n) {
		String s = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '1') {
				count++;
			}
		}
		return count;
	}

}
