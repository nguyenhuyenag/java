package learn;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		// String word = "Đế Bá";
		String str = "Đế Bá truyện tàng thư viện Đế Bá Lý Thất Đế    Bá Hoặc không Đế";
		// System.out.println(StringUtils.countMatches(text, word));

		System.out.println(Arrays.toString(StringUtils.split(str, "\\s+")));
	}

}
