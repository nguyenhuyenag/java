package bigocoder.nmlt;

import java.util.Scanner;

public class NMLT_COUNTAPPEARANCE {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s = io.nextLine();
			char[] arr = s.toCharArray();
			s = io.nextLine();
			char c = s.charAt(0);
			int count = 0;
			for (char x : arr) {
				if (x == c) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
