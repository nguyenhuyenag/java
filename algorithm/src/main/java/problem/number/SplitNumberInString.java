package problem.number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitNumberInString {

	public static void byWhileLoop() {
		String s = "string-1234more567string890";
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

	public static void byPattern() {
		Pattern p = Pattern.compile("(-?\\d+_");
		Matcher m = p.matcher("string-1234more567string890");
		while (m.find()) {
			System.out.println(m.group());
		}
	}

	public static int find1() {
		String s = "string-1234more567string890";
		int sum = 0, temp = 0, sign = 1;
		// loop through string
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				// was previous character a negative sign
				if (i > 0 && s.charAt(i - 1) == '-') {
					sign = -1;
				}
				// subtract '0' to convert char to binary
				// then convert entire number to binary
				temp = temp * 10 + c - '0';
			} else {
				// non digit encountered so add to sump
				sum = sum + (sign * temp);
				System.out.println("sum = " + sum);
				temp = 0;
				sign = 1;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// byPattern();
		// byWhileLoop();
		find1();
	}
}
