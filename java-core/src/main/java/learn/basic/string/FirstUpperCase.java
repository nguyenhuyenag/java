package learn.basic.string;

import org.apache.commons.lang3.StringUtils;

public class FirstUpperCase {

	public static String firstUpperCase(String str) {
		if (StringUtils.isEmpty(str)) {
			return StringUtils.EMPTY;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static void main(String[] args) {
		String s = "java";
		System.out.println(firstUpperCase(s));
		System.out.println(StringUtils.capitalize(s));
	}

}
