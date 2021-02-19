package leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/sum-of-unique-elements/
public class SumUniqueElements {

	public static boolean isUnique(int[] arr, int key) {
		int count = 0;
		for (int x : arr) {
			if (x == key) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public int sumOfUnique(int[] nums) {
		List<Integer> ignores = new ArrayList<>();
		int sum = 0;
		for (int x : nums) {
			if (isUnique(nums, x) & !ignores.contains(x)) {
				sum += x;
			}
		}
		return sum;
	}

}
