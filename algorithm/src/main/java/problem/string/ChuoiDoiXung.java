package problem.string;

import java.util.Scanner;

// Kiểm tra chuỗi đối xứng
public class ChuoiDoiXung {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String s = io.nextLine();
			int i, len = s.length();
			StringBuilder reverse = new StringBuilder(len);
			for (i = len - 1; i >= 0; i--) {
				reverse.append(s.charAt(i));
			}
			if (s.equals(reverse.toString())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
