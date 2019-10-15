package bigocoder.nmlt;

import java.util.Scanner;

/**
 * Gọi res là chiều dài dãy con dương dài nhất, cnt là chiều dài dãy con dương
 * hiện tại.
 * 
 * Duyệt qua tất cả các phần tử của mảng, với mỗi phần tử a_i ​​ta kiểm tra, nếu
 * a_i > 0 thì tăng cnt 1 đơn vị, ngược lại thì ta gán res = max(res, cnt), đồng
 * thời cho cnt = 0.
 * 
 * In max(res, cnt)
 * 
 */
public class DayConDuong {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = io.nextInt();
			}
			int i, length = arr.length;
			int res = 0; // chiều dài dãy con dương dài nhất
			int cnt = 0; // chiều dài dãy con dương hiện tại
			for (i = 0; i < length; i++) {
				if (arr[i] > 0) {
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
