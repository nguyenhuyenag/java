package leetcode.incomplete;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

	public static String getMax(String s1, String s2) {
		return s1.length() > s2.length() ? s1 : s2;
	}

	public static boolean isPalindromic(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		if (n < 2 || isPalindromic(s)) {
			return s;
		}
		String max = "";
		for (int i = 0; i < n; i++) {
			String s1 = s.substring(i, n);
			if (isPalindromic(s1)) {
				max = getMax(max, s1);
			}
			for (int j = s1.length() - 1; j >= 0; j--) {
				String s2 = s1.substring(0, j);
				if (isPalindromic(s2)) {
					max = getMax(max, s2);
				}
			}
		}
		if (max.length() > 0) {
			return max;
		}
		return String.valueOf(s.charAt(0));
	}

	public static void main(String[] args) {
		String s = "jfbnhnjamsfsbsslcaaivnzryrrkcqmektqjnymeifxvvskicpxxrztysetlpucxfqccmeyptxxziqhacxatxjynmbblssyaxvcmbtyrtqfwxrwsgfrinfkczktytwglbrskeogamecvihkywnljnqfmrrnqcvopcoyroncwzhdqzvwdbtjmcocwljjvipabzorajqgiabqjeyasbrjvyjtdvgupqtmydfgdczaodyokxxarfboxifcltizhhntciffijclljvdfgpsojwmupgtrbquuzjdefnmxtcaborisjcsavucmuovlksonzvmmuvujzirioxdcadeioravjoyxhrqevfwmxacimtvbmfweqpvfijyuqrjfgejrnlmhvbbmbvviilsothgvaqgqtllonrqbsltwpikfrckdhttxzmbqmbhbjjwfddnrfwtafgjtuqyatkpcavokouftqwdzfclkckwzfwlozksgkrcyimvdhfrzlqqxnfhjkwfiewwqmbfyjdjematsvusmqxzwfyukqwlfzzyzlkqvgmq";
		System.out.println(longestPalindrome(s));
	}

	@Test
	public void test() {
//		assertEquals("aba", longestPalindrome("babad")); // bab
//		assertEquals("bb", longestPalindrome("cbbd"));
//		assertEquals("a", longestPalindrome("a"));
//		assertEquals("a", longestPalindrome("ac"));
		// assertEquals("cc", longestPalindrome("ccd"));
		// assertEquals("bb", longestPalindrome("cbbd"));
		// assertEquals("bb", longestPalindrome("bb"));
		// assertEquals("bb", longestPalindrome("abb"));
		assertEquals("aca", longestPalindrome("aacabdkacaa"));
	}

}
