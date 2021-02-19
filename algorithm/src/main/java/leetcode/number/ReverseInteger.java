package leetcode.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

	public static long handleReverse(long n) {
		StringBuilder str = new StringBuilder(String.valueOf(n));
		return Long.parseLong(str.reverse().toString());
	}

	public static int reverse(int n) {
		long res = n;
		res = res > 0 ? handleReverse(res) : -handleReverse(-res);
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) res;
	}

	@Test
	public void test() {
		assertEquals(0, reverse(0));
		assertEquals(21, reverse(120));
		assertEquals(321, reverse(123));
		assertEquals(-321, reverse(-123));
	}

}
