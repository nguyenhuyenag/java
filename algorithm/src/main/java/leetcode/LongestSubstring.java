package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int n, len = 0, max = 0;
		String[] arr = s.split("");
		n = arr.length;
		if (s.length() < 2) {
			return s.length();
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++) {
			str.append(arr[i]); // chèn chuỗi tại vị trí i vào str
			for (int j = i + 1; j < n; j++) { // từ vị trí 'i + 1'
				if (str.indexOf(arr[j]) == -1) { // nếu không có trong str
					str.append(arr[j]); // thì chèn nó vào str
				} else { // nếu đã có
					break; // thoát
				}
			}
			len = str.length(); // tính độ dài str hiện tại
			if (max < len) { // so sánh với max
				max = len;
			}
			str.setLength(0); // xóa str
		}
		if (max > 0) {
			return max;
		}
		return str.length();
	}

	@Test
	public void test() {
		assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		assertEquals(1, lengthOfLongestSubstring(" "));
		assertEquals(0, lengthOfLongestSubstring(""));
		assertEquals(2, lengthOfLongestSubstring("au"));
	}

}
