package learn;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String str = io.nextLine();
			StringBuffer sb = new StringBuffer(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
		}
	}
}
