package com;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// số bước dịch chuyển
		final int STEP_MOVE = 2;
		// chuỗi thực tế cần dịch chuyển
		StringBuilder sb = new StringBuilder();
		char arr[] = { 'A', 'B', 'C', 'D', 'A', 'A', 'E' };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 'A') {
				sb.append(arr[i]);
			}
		}
		int len = sb.length() - 1;
		// ở mỗi bước ta dời phần tử cuối lên đầu
		for (int i = 0; i < STEP_MOVE; i++) {
			char last = sb.charAt(len);
			sb.deleteCharAt(len);
			sb.insert(0, last);
		}
		// chèn lại các vị trí của A
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'A') {
				sb.insert(i, "A");
			}
		}
		System.out.println(Arrays.toString(sb.toString().split("")));
	}

}
