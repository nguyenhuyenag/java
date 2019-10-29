package learn.recursion.backtracking;

import java.util.Scanner;

/**
 * Sinh các dãy nhị phân có độ dài n. Ví dụ n = 2, ta có các dãy: 00, 01, 10, 11
 * 
 * @see Integer#toBinaryString
 */
public class DayNhiPhan {

	static void output() {
		StringBuilder builder = new StringBuilder();
		for (int var : arr) {
			builder.append(var);
		}
		System.out.println(builder.toString());
	}

	/*-
	 * n = 2
	 * 
	 * i = 0	j = 0	=>	a[0] = 0		=>	Đệ quy
	 * 
	 *	  					i = 1	j = 0	=>	a[1] = 0	=>	00
	 *
	 *						  		j = 1	=>	a[1] = 1	=>	01
	 *
	 *			j = 1	=>	a[0] = 1		=>	Đệ quy
	 *
	 *						i = 1	j = 0	=>	a[1] = 0	=>	10
	 *			
	 *								j = 1	=>	a[1] = 1	=>	11
	 */
	static void quaylui(int i) {
		for (int j = 0; j <= 1; j++) { // j = {0, 1}
			arr[i] = j;
			if (i == (n - 1)) { // Nếu i nằm ở cuối mảng => in ra cấu hình tìm được
				output();
			} else {
				quaylui(i + 1); // ngược lại, thử các giá trị cho vị trí tiếp theo
			}
		}
	}

	static int n;
	static int[] arr;

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			n = 2; // io.nextInt();
			arr = new int[n];
			quaylui(0);
		}
	}

}
