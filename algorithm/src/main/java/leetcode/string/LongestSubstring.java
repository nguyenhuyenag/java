package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Chuỗi dài nhất không có ký tự trùng nhau
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int max = 0;
		String[] arr = s.split("");
		int n = arr.length;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++) {
			str.append(arr[i]); 					// thêm vào str
			for (int j = i + 1; j < n; j++) { 	// từ vị trí 'i + 1'
				if (str.indexOf(arr[j]) != -1) {	// nếu đã có trong str thì thoát
					break;
				}
				str.append(arr[j]); 				// nếu chưa thì thêm vị trí 'i + 1' vào str
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
