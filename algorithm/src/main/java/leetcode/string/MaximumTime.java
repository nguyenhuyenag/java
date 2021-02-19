package leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
public class MaximumTime {

	public static String maximumTime(String time) {
		char c = '?';
		char[] arr = time.toCharArray();
		if (arr[4] == c) {
			arr[4] = '9';
		}
		if (arr[3] == c) {
			arr[3] = '5';
		}
		// a0 = ?
		if (arr[0] == c) {
			// a1 = ?
			if (arr[1] == c) {
				arr[0] = '2';
				arr[1] = '3';
			} else { // a1 != ?
				if (arr[1] <= '3') {
					arr[0] = '2';
				} else {
					arr[0] = '1';
				}
			}
		} else {
			if (arr[0] == '0' || arr[0] == '1') {
				if (arr[1] == c) {
					arr[1] = '9';
				}
			}
			if (arr[0] == '2') {
				if (arr[1] == c) {
					arr[1] = '3';
				}
			}
		}
		return new String(arr);
	}

	@Test
	public void test() {
		assertEquals("23:50", maximumTime("2?:?0"));
		assertEquals("14:03", maximumTime("?4:03"));
	}

}
