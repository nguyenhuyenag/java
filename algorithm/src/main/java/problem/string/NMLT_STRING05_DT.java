package problem.string;

import java.util.Scanner;

public class NMLT_STRING05_DT {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String str = io.nextLine();
			String[] arr = str.trim().split("\\s");
			int i, length = arr.length;
			str = arr[0];
			arr[0] = arr[length - 1];
			arr[length - 1] = str;
			for (i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
