package problem.string;

import java.util.Scanner;

public class NMLT_MIX {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s = io.nextLine();
			int i;
			for (i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(Character.toUpperCase(s.charAt(i)));
				} else {
					System.out.print(Character.toLowerCase(s.charAt(i)));
				}
			}
		}
	}
}
