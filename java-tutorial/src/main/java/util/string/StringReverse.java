package util.string;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StringReverse {

	public static String reverse(String str) {
		char[] chars = str.toCharArray();
		ArrayUtils.reverse(chars);
		return new String(chars);
	}

	public static void main(String[] args) {
		String str = "StringUtils";
		System.out.println(reverse(str));
		System.out.println(StringUtils.reverse(str));
	}

}
