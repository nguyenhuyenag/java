package leetcode.incomplete;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

// https://leetcode.com/problems/longest-palindromic-substring/
// Chuỗi đối xứng dài nhất
public class LongestPalindromicSubstring {

	public static String getMax(String s1, String s2) {
		return s1.length() > s2.length() ? s1 : s2;
	}

	public static boolean isPalindromic(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static String longestPalindrome(String s) {
		if (isPalindromic(s)) {
			return s;
		}
		String max = "";
		int n = s.length();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < n; j++) {
				sb.append(s.charAt(j));
				if (isPalindromic(sb.toString())) {
					max = getMax(max, sb.toString());
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
		assertThat(longestPalindrome("ac"), anyOf(is("a"), is("c")));
		// assertEquals(longestPalindrome("babad"), anyOf(is("bab"), is("aba")));
	}

}
