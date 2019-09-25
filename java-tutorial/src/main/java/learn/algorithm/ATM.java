package learn.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class ATM {

	static void atm(int[][] coins, int n) {
		int i, menhGia, amounts;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int[] row : coins) {
			amounts = row[1];
			if (amounts > 0) {
				menhGia = row[0];
				for (i = amounts; i > 0; i--) {
					if (n >= i * menhGia) {
						map.put(menhGia, i); // Đổi được i tờ menhGia
						row[1] -= i; // Số tờ còn lại
						n -= i * menhGia; // Số tiền còn lại
						break;
					}
				}
			}
		}
		if (n == 0) {
			map.forEach((k, v) -> System.out.println(v + " tờ " + k));
			return;
		}
		System.out.println("ATM không đủ tiền, còn thiếu " + n);
	}

	// [mệnh giá, số lượng]
	static final int[][] ATMS = { //
			{ 200, 1 }, //
			{ 100, 5 }, //
			{ 5, 0 } //
	};

	public static void main(String[] args) {
		int n = 500;
		atm(ATMS, n);
	}

}
