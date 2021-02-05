package codewars.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://www.codewars.com/kata/55c45be3b2079eccff00010f
public class YourOrderPlease {

	public static String order(String words) {
		StringBuilder str = new StringBuilder("");
		String[] arr = words.split("\\s");
		for (int i = 1; i <= 9; i++) {
			for (String s : arr) {
				if (s.contains(String.valueOf(i))) {
					str.append(" " + s);
					break;
				}
			}
		}
		return str.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(order("is2 Thi1s T4est 3a"));
	}

	@Test
	public void test1() {
		assertEquals(YourOrderPlease.order("is2 Thi1s T4est 3a"), "Thi1s is2 3a T4est");
	}

	@Test
	public void test2() {
		assertEquals(YourOrderPlease.order("4of Fo1r pe6ople g3ood th5e the2"), "Fo1r the2 g3ood 4of th5e pe6ople");
	}

	@Test
	public void test3() {
		assertEquals(YourOrderPlease.order("Empty input should return empty string"), "");
	}

}
