package learn.generation;

import java.util.Arrays;

public class SinhDayNhiPhan {

	static void output(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	// Cấu hình ban đầu: 000...0 => cuối cùng: 111...1
	public static void main(String[] args) {
		int n = 2;
		int[] arr = new int[n];
		output(arr);							// in ra dãy đầu tiên
		for (int i = n - 1; i >= 0; i--) { 		// duyệt từ phần tử cuối -> phần tử đầu tiên
			if (arr[i] == 0) { 					// nếu gặp số 0
				arr[i] = 1; 					// đổi nó thành 1
				Arrays.fill(arr, i + 1, n, 0); 	// gán toàn bộ phần tử phía sau nó thành 0
				output(arr); 					// in ra dãy vừa sinh
				i = n; 							// Gán i = n (độ dài của chuỗi) để quay về cuối dãy và duyệt lên lại
			}
		}
	}

}
