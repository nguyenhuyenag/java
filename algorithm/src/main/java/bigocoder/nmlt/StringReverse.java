package bigocoder.nmlt;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String str = io.nextLine();
			int i, len = str.length();
			StringBuilder dest = new StringBuilder(len);
			for (i = (len - 1); i >= 0; i--) {
				dest.append(str.charAt(i));
			}
			if (str.equals(dest.toString())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
