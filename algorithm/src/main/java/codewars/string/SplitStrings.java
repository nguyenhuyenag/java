package codewars.string;

import java.util.Arrays;

// Cắt chuỗi thành chuỗi con có độ dài 2, nếu chuỗi con thiếu thì thêm ký tự `_` 
public class SplitStrings {

	public static String[] solution(String s) {
		s = (s.length() % 2 == 0) ? s : s + "_";
		int n = s.length() / 2;
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = s.substring(2 * i, 2 * i + 2);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(Arrays.toString(solution(s)));
	}

}
