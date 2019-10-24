package learn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherFind {
	
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) {

		final String TEXT = "This 1 is 2 a 234 String";

		// Khoảng trắng xuất hiện 1 hoặc nhiều lần
		String regex = "\\d+";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(TEXT);

		while (matcher.find()) {
			System.out.println("start: " + matcher.start() //
					+ ", end: " + matcher.end() //
					+ ", group: " + matcher.group());
		}

		System.out.println(TEXT.substring(5, 6));
		System.out.println(TEXT.substring(10, 11));
		
	}

}
