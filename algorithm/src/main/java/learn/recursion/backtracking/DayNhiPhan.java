package learn.recursion.backtracking;

import java.util.Scanner;

/**
 * Sinh các dãy nhị phân có độ dài n
 */
public class DayNhiPhan {

	static int n;
	static int[] arr;

	static void output() {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	static void find(int i) {
		for (int j = 0; j <= 1; j++) { // j = {0, 1}
			arr[i] = j;
			if (i == n - 1) {
				output(); // nếu tìm đến i cuối cùng thì in ra kết quả
			} else {
				find(i + 1); // chưa tìm đến i cuối thì tăng i
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
