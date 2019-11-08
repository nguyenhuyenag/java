package problem.string;

import java.util.Scanner;

public class NMLT_STRING01_KTC {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String str = io.nextLine();
			String[] arr = str.split("");
			for (String s : arr) {
				if (!s.matches("[a-zA-Z0-9\\s+]")) {
					System.out.println("YES");
					return;
				}
			}
			System.out.println("NO");
		}
	}

}
