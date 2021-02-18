package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int len, max = 0;
		String[] arr = s.split("");
		len = arr.length;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str.append(arr[i]); 					// chèn chuỗi tại vị trí i vào str
			for (int j = i + 1; j < len; j++) { 	// từ vị trí 'i + 1'
				if (str.indexOf(arr[j]) != -1) {	// nếu đã có trong str thì dừng
					break;
				}
				str.append(arr[j]); 				// nếu chưa thì chèn vào str
			}
			max = Math.max(max, str.length());		// chạy hết chuỗi hoặc bị thoát, so sánh str với max
			str.setLength(0);
		}
		return max; // > 0 ? max : str.length();
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
