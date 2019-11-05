package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IgnoreNewLine {

	/*-
	 * 4
	 * public
	 * static
	 * void
	 * main
	 */
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int n = io.nextInt();
			io.nextLine();
			List<String> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				String str = io.nextLine();
				String join = String.join("", list) + str;
				list.add(join);
			}
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
