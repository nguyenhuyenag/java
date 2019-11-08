package problem.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tách ký tự chữ ra khỏi chuỗi
 */
public class SplitCharOutString {

	static public void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String s = io.nextLine();
			Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(s);
			while (matcher.find()) {
				System.out.print(matcher.group());
			}
		}
	}

}
