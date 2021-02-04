package codewars.number;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

// https://www.codewars.com/kata/550498447451fbbd7600041c
public class AreTheyTheSame {

	public static boolean comp(int[] a, int[] b) {
		if (a == null || b == null) {
			return false;
		}
		int[] arr = Arrays.stream(a).map(t -> t * t).toArray();
		Arrays.sort(arr);
		Arrays.sort(b);
		return Arrays.equals(arr, b);
	}

	@Test
	public void test1() {
		int[] a = new int[] { 121, 144, 19, 161, 19, 144, 19, 11 };
		int[] b = new int[] { 121, 14641, 20736, 361, 25921, 361, 20736, 361 };
		assertEquals(true, AreTheyTheSame.comp(a, b));
	}

}
