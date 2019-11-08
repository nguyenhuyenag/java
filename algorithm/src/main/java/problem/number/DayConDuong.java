package problem.number;

import java.util.Scanner;

/**
 * - Tìm dãy con toàn dương dài nhất trong mảng
 * 
 * - Gọi res là chiều dài dãy con dương dài nhất,
 * 		 cnt là chiều dài dãy con dương hiện tại.
 * 
 * - Duyệt mảng, với mỗi phần tử k ​​ta kiểm tra, nếu k > 0 thì tăng cnt 1 đơn vị, ngược lại thì ta gán res = max(res, cnt), đồng
 * thời đặt cnt = 0.
 * 
 * - KQ: max(res, cnt)
 * 
 */
public class DayConDuong {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int n = io.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.nextInt();
			}
			int res = 0, cnt = 0;
			for (int k : arr) {
				if (k > 0) {
					cnt++;
				} else {
					if (cnt > res) {
						res = cnt;
					}
					cnt = 0;
				}
			}
			System.out.println(Math.max(res, cnt));
		}
	}

}
