package bigocoder.nmlt.number;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitNumber {
	public static void byWhileLoop() {
		try (Scanner io = new Scanner(System.in)) {
			String s = io.nextLine();
			int i = 0, j = 0, length = s.length();
			while (i < length) {
				// Nếu vị trí i là số
				if (Character.isDigit(s.charAt(i))) {
					for (j = i + 1; j < length; j++) {
						// Vị trí kế tiếp không phải là số là số
						if (!Character.isDigit(s.charAt(j))) {
							break; // dừng
						}
						// tiếp tục
					}
					System.out.println(s.substring(i, j));
					i = j + 1;
					continue;
				} else {
					i++;
				}
			}
		}
	}

	public static void byPattern() {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("string1234more567string890");
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String str = io.nextLine();
			String[] arr = str.replaceAll("\\D+", " ").split("\\s");
			for (String s : arr) {
				System.out.println(s);
			}
		}
	}
}
