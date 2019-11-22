package com.recursion.backtracking;

/**
 * Sinh các dãy nhị phân có độ dài n.
 * 
 * Ví dụ n = 2, ta có các dãy: 00, 01, 10, 11
 * 
 * Có tất cả 2^n trường hợp
 * 
 * @see Integer#toBinaryString
 * 
 * @see https://i.imgur.com/nQOPC1I.png
 */
public class DayNhiPhan {

	static void output() {
		StringBuilder builder = new StringBuilder();
		for (int var : arr) {
			builder.append(var);
		}
		System.out.println(builder.toString());
	}

	static void backtrack(int i) {
		for (int j = 0; j <= 1; j++) {	// j = {0, 1}
			arr[i] = j;
			if (i == (n - 1)) { 		// Nếu i nằm ở cuối mảng => in ra cấu hình tìm được
				output();
			} else {
				backtrack(i + 1); 		// ngược lại, thử các giá trị cho vị trí tiếp theo
			}
		}
	}

	static int n;
	static int[] arr;

	public static void main(String[] args) {
		n = 2;
		arr = new int[n];
		backtrack(0);
	}

}
