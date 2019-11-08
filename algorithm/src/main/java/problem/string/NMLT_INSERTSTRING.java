package problem.string;

import java.util.Scanner;

public class NMLT_INSERTSTRING {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s1 = io.nextLine();
			String s2 = io.nextLine();
			int k = io.nextInt();
			int i;
			boolean check = false;
			for (i = 0; i < s1.length(); i++) {
				System.out.print(s1.charAt(i));
				if (i >= k && !check) {
					System.out.print(s2);
					check = true;
				}
			}
		}
	}
}
