package leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

// https://leetcode.com/problems/rearrange-words-in-a-sentence/
public class RearrangeWords {

	public static String arrangeWords(String text) {
		String[] arr = text.toLowerCase().split(" ");
		Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
		String str = String.join(" ", arr);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	@Test
	public void test() {
		assertEquals("Is cool leetcode", arrangeWords("Leetcode is cool"));
		assertEquals("On and keep calm code", arrangeWords("Keep calm and code on"));
		assertEquals("To be or to be not", arrangeWords("To be or not to be"));
	}

}
