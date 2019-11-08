package problem.string;

import java.util.Scanner;

public class NMLT_STRING04_VTXHCC {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s1 = io.nextLine();
			String s2 = io.nextLine();
			int i = 0, index = -1, len2 = s2.length();
			while (i + len2 <= s1.length()) {
				if (s2.equals(s1.substring(i, i + len2))) {
					index = i;
				}
				i++;
			}
			System.out.println(index);
		}
	}
}
