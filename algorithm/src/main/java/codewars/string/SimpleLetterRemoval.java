package codewars.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://www.codewars.com/kata/5b728f801db5cec7320000c7
public class SimpleLetterRemoval {

	public static String solve(String s, int k) {
		int count = 0;
		StringBuilder str = new StringBuilder(s);
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < str.length(); i++) {
				if (count < k && c == str.charAt(i)) {
					str.setCharAt(i, '_');
					count++;
				}
			}
		}
		return str.toString().replace("_", "");
	}

	@Test
	public void basicTests() {
		doTest("abracadabra", 50, "");
		doTest("abracadabra", 8, "rdr");
		doTest("abracadabra", 6, "rcdbr");
		doTest("abracadabra", 2, "brcadabra");
		doTest("abracadabra", 1, "bracadabra");
	}

	private void doTest(String s, int k, String expected) {
		assertEquals(expected, SimpleLetterRemoval.solve(s, k));
	}

}
