package codewars.incomplete;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

// https://www.codewars.com/kata/55983863da40caa2c900004e
public class NextBiggerSameDigits {

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static long nextBiggerNumber(long n) {
		char[] arr = String.valueOf(n).toCharArray();
		int i, len = arr.length;
		// Start from the right most digit and find the
		// first digit that is smaller than the digit next to it.
		for (i = len - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1]) {
				break;
			}
		}
		// If no such digit is found, then all digits are in descending
		// order means there cannot be a greater number with same set of digits
		if (i == 0) {
			return n;
		}
		int min = i, x = arr[i - 1];
		// Find the smallest digit on right side of (i - 1)'th digit that is greater
		// than number[i-1]
		for (int j = i + 1; j < len; j++) {
			if (arr[j] > x && arr[j] < arr[min]) {
				min = j;
			}
		}
		// Swap the above found smallest digit with number[i-1]
		swap(arr, i - 1, min);
		// Sort the digits after (i-1) in ascending order
		Arrays.sort(arr, i, len);
		return Long.parseLong(new String(arr));
	}

	@Test
	public void basicTests() {
		assertEquals(21, NextBiggerSameDigits.nextBiggerNumber(12));
		assertEquals(531, NextBiggerSameDigits.nextBiggerNumber(513));
		assertEquals(2071, NextBiggerSameDigits.nextBiggerNumber(2017));
		assertEquals(441, NextBiggerSameDigits.nextBiggerNumber(414));
		assertEquals(414, NextBiggerSameDigits.nextBiggerNumber(144));
		assertEquals(19009, NextBiggerSameDigits.nextBiggerNumber(10990));
		// assertEquals(9876543210, NextBiggerSameDigits.nextBiggerNumber(9876543210));
	}

}
