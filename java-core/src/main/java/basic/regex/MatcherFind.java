package basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherFind {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) {
		String s = ":ajsdkjh12837hdqh8923yehwđ823327uash";
		Matcher matcher = Pattern.compile("\\d+").matcher(s);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
