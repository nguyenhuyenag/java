package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Chuỗi đối xứng dài nhất
// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

	// Kiểm tra chuỗi đối xứng
	public static boolean isPalindromic(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static String longestPalindrome(String str) {
		if (isPalindromic(str)) {
			return str;
		}
		String max = "";
		int n = str.length();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < n; j++) {
				sb.append(str.charAt(j));
				String s = sb.toString();
				if (isPalindromic(s)) {
					max = (s.length() > max.length() ? s : max);
				}
			}
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals("bb", longestPalindrome("cbbd"));
		assertEquals("a", longestPalindrome("a"));
		assertEquals("cc", longestPalindrome("ccd"));
		assertEquals("bb", longestPalindrome("cbbd"));
		assertEquals("bb", longestPalindrome("bb"));
		assertEquals("bb", longestPalindrome("abb"));
		assertEquals("aca", longestPalindrome("aacabdkacaa"));
		// assertThat(longestPalindrome("ac"), anyOf(is("a"), is("c")));
		// assertEquals(longestPalindrome("babad"), anyOf(is("bab"), is("aba")));
	}

}
