package codewars.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// https://www.codewars.com/kata/5a946d9fba1bb5135100007c
public class TransformToPrime {

	public static boolean isPrime(int n) {
		if (n == 2 || n % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(n);
		for (int i = 3; i <= sqrt; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int minimumNumber(int[] arr) {
		int s = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			s += arr[i];
		}
		int snext = s;
		while (true) {
			if (isPrime(snext)) {
				return snext - s;
			}
			snext++;
		}
	}

	public static void main(String[] args) {
		System.out.println(isPrime(31));
	}

	@Test
	public void checkSmallArraySize() {
		assertEquals(1, TransformToPrime.minimumNumber(new int[] { 3, 1, 2 }));
		assertEquals(0, TransformToPrime.minimumNumber(new int[] { 5, 2 }));
		assertEquals(0, TransformToPrime.minimumNumber(new int[] { 1, 1, 1 }));
	}

	@Test
	public void checkLargerArraySize() {
		assertEquals(5, TransformToPrime.minimumNumber(new int[] { 2, 12, 8, 4, 6 }));
		assertEquals(2, TransformToPrime.minimumNumber(new int[] { 50, 39, 49, 6, 17, 28 }));
	}

}
