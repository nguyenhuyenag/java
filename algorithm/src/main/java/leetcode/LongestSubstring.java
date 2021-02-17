package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		if (len < 2) {
			return len;
		}
		int count, max = 0;
		for (int i = 0; i < len; i++) {
			count = 1;
			for (int j = i + 1; j < len; j++) {
				if (arr[i] == arr[j]) {
					if (max < count) {
						max = count;
					}
					break;
				}
				count++;
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		assertEquals(1, lengthOfLongestSubstring(" "));
		assertEquals(0, lengthOfLongestSubstring(""));
		// assertEquals(2, lengthOfLongestSubstring("au"));
	}

}
