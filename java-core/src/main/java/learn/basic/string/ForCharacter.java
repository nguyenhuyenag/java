package learn.basic.string;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class ForCharacter {

	public static String firstUpperCase(String str) {
		if (StringUtils.isEmpty(str)) {
			return StringUtils.EMPTY;
		}
		// return StringUtils.capitalize(str);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String deleteIndex(String s, int index) {
		if (index < 0 || index > s.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range");
		}
		return s.substring(0, index) + s.substring(index + 1);
	}

	public static String reverse(String str) {
		char[] chars = str.toCharArray();
		ArrayUtils.reverse(chars);
		// return StringUtils.reverse(str);
		return new String(chars);
	}

	public static void splitAndJoin() {
		String str = "public static void main";
		String regex = " ";
		String[] split = str.split(regex);
		System.out.println(Arrays.toString(split));
		System.out.println(String.join(regex, split));
		System.out.println(StringUtils.join(split, regex));
	}

	public static void main(String[] args) {
		// String s = "java";
		// deleteIndex(s, 5);
		// firstUpperCase(s);
		// reverse(s);
		splitAndJoin();
	}

}
