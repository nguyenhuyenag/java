package codewars.incomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.codewars.com/kata/55983863da40caa2c900004e
public class NextBiggerSameDigits {
	
	List<Long> list = new ArrayList<>();
	
	private static void permute(List<?> list, int left, int right) {
		if (left == right) {
			System.out.println(Arrays.toString(list.toArray()));
			// String.join(",", list);
			return;
		}
		for (int j = left; j <= right; j++) {
			Collections.swap(list, left, j);
			permute(list, left + 1, right);
			Collections.swap(list, left, j); // backtrack
		}
	}

	public static void showAllPermute(List<?> list) {
		int size = list.size();
		permute(list, 0, list.size() - 1);
	}
	
	public static long nextBiggerNumber(long n) {
		return n;
	}
	
	public static void main(String[] args) {
		long n = 123456;
		int[] arr = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
		// int max = new StringBui
	}
	
}
