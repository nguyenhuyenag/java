package problem.number;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Số lượng của chữ số lớn nhất
 */
public class SoLuongChuSo {
	
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			String[] arr = String.valueOf(n).split("");
			int max = Integer.parseInt(arr[0]);
			TreeMap<String, Integer> map = new TreeMap<>();
			int tmp;
			for (String key : arr) {
				tmp = Integer.parseInt(key);
				if (tmp > max) {
					max = tmp;
				}
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}
			System.out.println(map.get(String.valueOf(max)));
			// System.out.println(map.lastEntry().getValue());
		}
	}
	
}
