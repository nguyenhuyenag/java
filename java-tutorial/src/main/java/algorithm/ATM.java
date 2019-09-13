package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ATM {

	static void atm(int[][] coins, int N) {
		int i, menhGia, amounts;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int[] row : coins) {
			amounts = row[1];
			if (amounts > 0) {
				menhGia = row[0];
				for (i = amounts; i > 0; i--) {
					if (N >= i * menhGia) {
						map.put(menhGia, i); // Đổi được i tờ menhGia
						row[1] -= i; // Số tờ còn lại
						N -= i * menhGia; // Số tiền còn lại
						break;
					}
				}
			}
		}
		if (N == 0) {
			map.entrySet().stream() //
					.sorted(Map.Entry.comparingByKey()) //
					.forEach(t -> System.out.println(t.getValue() + " tờ " + t.getKey()));
			return;
		}
		System.out.println("ATM không đủ tiền, còn thiếu " + N);
	}

	// [mệnh giá, số lượng]
	static final int[][] ATM = { //
			{ 200, 1 }, //
			{ 100, 5 }, //
			{ 5, 0 } //
	};

	public static void main(String[] args) {
		int N = 500;
		atm(ATM, N);
	}

}
