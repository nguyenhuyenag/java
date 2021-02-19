package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {

	public static int lengthOfLastWord(String str) {
		String[] arr = str.split(" ");
		int n = arr.length;
		if (n == 0) {
			return 0;
		}
		return arr[n - 1].length();
	}

	public int bestProof(String str) {
		str = str.trim();
		int last = str.lastIndexOf(" ") + 1;
		return str.length() - last;
	}

	@Test
	public void test() {
		assertEquals(5, lengthOfLastWord("Hello World"));
		assertEquals(0, lengthOfLastWord(""));
		assertEquals(0, lengthOfLastWord(" "));
		assertEquals(1, lengthOfLastWord("a"));
	}

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(lengthOfLastWord(s));
	}

}
