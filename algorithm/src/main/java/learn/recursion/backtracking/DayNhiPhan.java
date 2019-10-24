package learn.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Sinh các dãy nhị phân có độ dài n
 */
public class DayNhiPhan {

	private static List<String> list = new ArrayList<>();

	private static void quayLui(int[] arr, int n, int i) {
		for (int j = 0; j <= 1; j++) { // j = {0, 1}
			arr[i] = j;
			if (i == (n - 1)) {
				StringBuilder builder = new StringBuilder();
				for (int var : arr) {
					builder.append(var);
				}
				list.add(builder.toString());
			} else {
				quayLui(arr, n, i + 1);
			}
		}
	}

	public static List<String> binarySeq(int n) {
		int[] arr = new int[n];
		quayLui(arr, n, 0);
		return list; // 2^n day
	}

	public static void main(String[] args) {
		// binarySeq(0).forEach(System.out::println);
		for (int i = 0; i < Math.pow(2, 4); i++) {
			System.out.println(Integer.toBinaryString(i));
		}
	}

}
