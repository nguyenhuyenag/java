package bigocoder.nmlt.string;

import java.util.Scanner;

public class NMLT_COUNTCHAR {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s = io.nextLine();
			int i, count = 0;
			for (i = 0; i < s.length(); i++) {
				if (Character.isAlphabetic(s.charAt(i))) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
