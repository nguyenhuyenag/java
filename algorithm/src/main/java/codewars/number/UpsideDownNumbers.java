package codewars.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UpsideDownNumbers {

	public static boolean check(int x) {
		String n = String.valueOf(x);
		String nem = n.replaceAll("[01689]", "");
		if (nem.length() > 0) {
			return false;
		}
		String str = new StringBuilder(n).reverse().toString();
		str = str.replaceAll("6", "t") //
				.replaceAll("9", "6") //
				.replaceAll("t", "9");
		return n.equals(str);
	}

	public static int solve(int x, int y) {
		int count = 0;
		for (int i = x; i < y; i++) {
			if (check(i)) {
				count++;
			}
		}
		return count;
	}

	@Test
	public void basicTests() {
		assertEquals(3, UpsideDownNumbers.solve(0, 10));
		assertEquals(4, UpsideDownNumbers.solve(10, 100));
		assertEquals(12, UpsideDownNumbers.solve(100, 1000));
		assertEquals(20, UpsideDownNumbers.solve(1000, 10000));
		assertEquals(6, UpsideDownNumbers.solve(10000, 15000));
		assertEquals(9, UpsideDownNumbers.solve(15000, 20000));
		assertEquals(15, UpsideDownNumbers.solve(60000, 70000));
		assertEquals(55, UpsideDownNumbers.solve(60000, 130000));
	}

}
