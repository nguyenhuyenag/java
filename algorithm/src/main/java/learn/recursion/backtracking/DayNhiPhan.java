package learn.recursion.backtracking;

import java.util.Scanner;

/**
 * Sinh các dãy nhị phân có độ dài n
 */
public class DayNhiPhan {

	static int n;
	static int[] arr;
	static final int[] binary = { 0, 1 };

	static void output() {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	static void find(int i) {
		for (int k : binary) {
			arr[i] = k;
			if (i == n - 1) { // nếu tìm đến i cuối cùng thì in ra kết quả hiện tại
				output();
			} else { // chưa tìm đến i cuối thì tăng i
				find(i + 1);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			n = 2; // io.nextInt();
			arr = new int[n];
			find(0);
		}
	}

}
