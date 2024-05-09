package basic.strings;

import org.apache.commons.lang3.StringUtils;

public class UnicodeUtils {

	public static boolean isUnicode(char c) {
		return (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN);
	}

	public static boolean isUnicode2(char c) {
		if ((int) c > 127) {
			return true;
		}
		return false;
	}

	public static boolean isUnicode(String str) {
		for (char c : str.toCharArray()) {
			if (isUnicode(c)) {
				return true;
			}
		}
		return false;
	}

	// Remove accent: https://stackoverflow.com/a/27789934/10910098
	public static String flattenToAscii(String text) {
		// StringBuilder sb = new StringBuilder(text.length());
		// text = Normalizer.normalize(text, Normalizer.Form.NFD);
		return StringUtils.stripAccents(text).replaceAll("đ", "d");
	}

	public static String unicodeOf(char c) {
		return Integer.toHexString(c); // 'a' = "61"
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// System.out.println(isUnicode2('ã'));
		// System.out.println(isUnicode("ä"));
		// System.out.println(isUnicode("☹"));
		// System.out.println(isUnicode("+"));
		// System.out.println(isUnicode("@"));
		// System.out.println(isUnicode("]"));
		String s = "Năm 1979, khi đang là học sinh tại lớp chuyên toán trường Quốc học Huế, "
				+ "ông được chọn để tham gia kỳ thi Olympic Toán Quốc tế ở Luân Đôn cùng 4 học sinh khác";
		// System.out.println(flattenToAscii(s));
		// System.out.println(StringUtils.stripAccents(s));
		System.out.println(unicodeOf('x'));
	}

}
