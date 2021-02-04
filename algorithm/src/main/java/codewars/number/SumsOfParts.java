package codewars.number;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

// https://www.codewars.com/kata/5ce399e0047a45001c853c2b
public class SumsOfParts {

	public static int[] _sumParts(int[] ls) {
		int len = ls.length;
		if (len == 0) {
			return new int[] { 0 };
		}
		int n = len + 1;
		int[] arr = new int[n];
		int total = Arrays.stream(ls).sum();
		int t = 0;
		arr[0] = total;
		for (int i = 0; i < len; i++) {
			t += ls[i];
			arr[i + 1] = total - t;
		}
		arr[n - 1] = 0;
		return arr;
	}

	public static int[] sumParts(int[] ls) {
		int n = ls.length;
		int[] arr = new int[n + 1];
		int sum = Arrays.stream(ls).sum();
		for (int i = 0; i < n; i++) {
			arr[i] = sum;
			sum -= ls[i];
		}
		return arr;
	}

	private static void dotest(int[] ls, int[] expect) {
		int[] actual = SumsOfParts.sumParts(ls);
		assertArrayEquals(expect, actual);
	}

	@Test
	public void test() {
		dotest(new int[] {}, new int[] { 0 });
		dotest(new int[] { 0, 1, 3, 6, 10 }, new int[] { 20, 20, 19, 16, 10, 0 });
		dotest(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 21, 20, 18, 15, 11, 6, 0 });
		dotest(new int[] { 744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358 }, new int[] { 10037855,
				9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0 });

	}

	public static void main(String[] args) {
		System.out.println();
	}

}
