package util.string;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringSplitAndJoin {

	public static void main(String[] args) {

		String str = "public static void main";

		String regex = " ";

		String[] split = str.split(regex);

		System.out.println(Arrays.toString(split));

		System.out.println(String.join(regex, split));

		System.out.println(StringUtils.join(split, regex));

	}

}
