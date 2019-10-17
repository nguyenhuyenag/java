package bigocoder.nmlt;

import java.util.Scanner;

public class NMLT_STRING02_DKTC {

	public static String process(String s) {
		int len = s.length();
		return s.substring(0, len - 1) + s.substring(len - 1, len).toUpperCase();
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();
			for (String s : str.split("\\s+")) {
				System.out.print(process(s) + " ");
			}
		}
	}
}
